package com.vsked.ocr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.AuthExpireTime;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.sinovoice.hcicloudsdk.common.InitParam;
import com.vsked.entity.AccountInfo;
import com.vsked.util.FileUtil;

public class HciCloudSysHelper {
	
    static {
    	System.out.println("ff1");
		// 灵云sdk中dll文件目录
		String libPath = FileUtil.getBasePath()+"../" + "lib";
		// 指定dll文件路径，顺序表示加载顺序
		String sysLibPath[] = new String[] { 
				libPath + "\\libcurl.dll",
				libPath + "\\hci_sys.dll", 
				libPath + "\\hci_sys_jni.dll" 
		};
		// 加载hci_sys.dll
		HciLibPath.setSysLibPath(sysLibPath);
    }
    
    private static HciCloudSysHelper mInstance;

    private HciCloudSysHelper() {
    }

    public static HciCloudSysHelper getInstance() {
        if (mInstance == null) {
            mInstance = new HciCloudSysHelper();
        }
        return mInstance;
    }

    /**
     * HciCloud系统初始化
     * 
     * @return 初始化状态，成功或失败
     */
    public int init(String userInfoPath) {
    	// 加载信息,返回InitParam, 获得配置参数的字符串
        InitParam initParam = getInitParam(userInfoPath);
        String strConfig = initParam.getStringConfig();
        System.out.println("hciInit strConfig value:" + strConfig);

        // 初始化
        int initResult = HciCloudSys.hciInit(strConfig, null);
        if (initResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("hciInit error: " + initResult);
            return initResult;
        } else {
        	System.out.println("hciInit success");
        }

        // 获取授权/更新授权文件 :
        initResult = checkAuth();
        if (initResult != HciErrorCode.HCI_ERR_NONE) {
            // 由于系统已经初始化成功,在结束前需要调用方法hciRelease()进行系统的反初始化
            HciCloudSys.hciRelease();
            return initResult;
        }

        return HciErrorCode.HCI_ERR_NONE;
    }

    /**
     * 系统反初始化
     */
    public int release() {
    	int nRet = HciCloudSys.hciRelease();
    	return nRet;
    }
    
    /**
     * 加载初始化信息
     * 
     * @return 系统初始化参数
     */
    private InitParam getInitParam(String userInfoPath) {
        String authDirPath = userInfoPath + "/UserInfo";
        String logPath = userInfoPath + "/Log";
        
        // 前置条件：无
        InitParam initparam = new InitParam();

        // 授权文件所在路径，此项必填
        initparam.addParam(InitParam.PARAM_KEY_AUTH_PATH, authDirPath);

        // 是否自动访问云授权,详见 获取授权/更新授权文件处注释
        initparam.addParam(InitParam.PARAM_KEY_AUTO_CLOUD_AUTH, "no");

        // 灵云云服务的接口地址，此项必填
        initparam.addParam(InitParam.PARAM_KEY_CLOUD_URL, AccountInfo.getInstance().getCloudUrl());

        // 开发者Key，此项必填，由捷通华声提供
        initparam.addParam(InitParam.PARAM_KEY_DEVELOPER_KEY, AccountInfo.getInstance().getDeveloperKey());

        // 应用Key，此项必填，由捷通华声提供
        initparam.addParam(InitParam.PARAM_KEY_APP_KEY, AccountInfo.getInstance().getAppKey());

        // 日志的路径，可选，如果不传或者为空则不生成日志
        initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_PATH, logPath);

        // 日志数目，默认保留多少个日志文件，超过则覆盖最旧的日志
        initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_COUNT, "5");

        // 日志大小，默认一个日志文件写多大，单位为K
        initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_SIZE, "1024");

        // 日志等级，0=无，1=错误，2=警告，3=信息，4=细节，5=调试，SDK将输出小于等于logLevel的日志信息
        initparam.addParam(InitParam.PARAM_KEY_LOG_LEVEL, "5");

        return initparam;
    }

    /**
     * 获取授权
     * 
     * @return true 成功
     */
    private int checkAuth() {
        // 获取系统授权到期时间
        int initResult;
        AuthExpireTime objExpireTime = new AuthExpireTime();
        initResult = HciCloudSys.hciGetAuthExpireTime(objExpireTime);
        if (initResult == HciErrorCode.HCI_ERR_NONE) {
        	// 显示授权日期,如用户不需要关注该值,此处代码可忽略
        	Date date = new Date(objExpireTime.getExpireTime() * 1000);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        	System.out.println("expire time: " + sdf.format(date));

            if (objExpireTime.getExpireTime() * 1000 < System.currentTimeMillis()) {
            	// 获取授权方法, 返回值为错误码
            	System.out.println("expired date");

                initResult = HciCloudSys.hciCheckAuth();
                if (initResult == HciErrorCode.HCI_ERR_NONE) {
                   System.out.println("hciCheckAuth success");
                   return initResult;
                } else {
                   System.out.println("hciCheckAuth failed: " + initResult);
                   return initResult;
                }
            } else {
                // 已经成功获取了授权,并且距离授权到期有充足的时间(>7天)
               System.out.println("hciCheckAuth success");
               return initResult;
            }
        } else if (initResult == HciErrorCode.HCI_ERR_SYS_AUTHFILE_INVALID) {
        	// 如果读取Auth文件失败(比如第一次运行,还没有授权文件),则开始获取授权
        	System.out.println("authfile invalid");

            initResult = HciCloudSys.hciCheckAuth();
            if (initResult == HciErrorCode.HCI_ERR_NONE) {
               System.out.println("hciCheckAuth success");
               return initResult;
            } else {
               System.out.println("hciCheckAuth failed: " + initResult);
               return initResult;
            }
        } else {
            // 其他失败原因,请根据SDK帮助文档中"常量字段值"中的错误码的含义检查错误所在
           System.out.println("getAuthExpireTime Error:" + initResult);
           return initResult;
        }
    }
}
