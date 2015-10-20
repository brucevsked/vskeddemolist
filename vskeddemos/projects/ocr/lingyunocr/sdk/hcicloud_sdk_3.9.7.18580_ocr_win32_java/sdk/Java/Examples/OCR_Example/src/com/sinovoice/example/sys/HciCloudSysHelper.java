package com.sinovoice.example.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.AuthExpireTime;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.sinovoice.hcicloudsdk.common.InitParam;

public class HciCloudSysHelper {
	
	String sPath = System.getProperty("user.dir");
    
    static {
		// ����sdk��dll�ļ�Ŀ¼
		String libPath = System.getProperty("user.dir") + "\\libs";
		// ָ��dll�ļ�·����˳���ʾ����˳��
		String sysLibPath[] = new String[] { 
				libPath + "\\libcurl.dll",
				libPath + "\\hci_sys.dll", 
				libPath + "\\hci_sys_jni.dll" 
		};
		// ����hci_sys.dll
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
     * HciCloudϵͳ��ʼ��
     * 
     * @return ��ʼ��״̬���ɹ���ʧ��
     */
    public int init() {
    	// ������Ϣ,����InitParam, ������ò������ַ���
        InitParam initParam = getInitParam();
        String strConfig = initParam.getStringConfig();
        System.out.println("hciInit strConfig value:" + strConfig);

        // ��ʼ��
        int initResult = HciCloudSys.hciInit(strConfig, null);
        if (initResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("hciInit error: " + initResult);
            return initResult;
        } else {
        	System.out.println("hciInit success");
        }

        // ��ȡ��Ȩ/������Ȩ�ļ� :
        initResult = checkAuth();
        if (initResult != HciErrorCode.HCI_ERR_NONE) {
            // ����ϵͳ�Ѿ���ʼ���ɹ�,�ڽ���ǰ��Ҫ���÷���hciRelease()����ϵͳ�ķ���ʼ��
            HciCloudSys.hciRelease();
            return initResult;
        }

        return HciErrorCode.HCI_ERR_NONE;
    }

    /**
     * ϵͳ����ʼ��
     */
    public int release() {
    	int nRet = HciCloudSys.hciRelease();
    	return nRet;
    }
    
    /**
     * ���س�ʼ����Ϣ
     * 
     * @return ϵͳ��ʼ������
     */
    private InitParam getInitParam() {
        String authDirPath = sPath + "\\UserInfo";
        String logPath = sPath + "\\Log";
        
        // ǰ����������
        InitParam initparam = new InitParam();

        // ��Ȩ�ļ�����·�����������
        initparam.addParam(InitParam.PARAM_KEY_AUTH_PATH, authDirPath);

        // �Ƿ��Զ���������Ȩ,��� ��ȡ��Ȩ/������Ȩ�ļ���ע��
        initparam.addParam(InitParam.PARAM_KEY_AUTO_CLOUD_AUTH, "no");

        // �����Ʒ���Ľӿڵ�ַ���������
        initparam.addParam(InitParam.PARAM_KEY_CLOUD_URL, AccountInfo.getInstance().getCloudUrl());

        // ������Key���������ɽ�ͨ�����ṩ
        initparam.addParam(InitParam.PARAM_KEY_DEVELOPER_KEY, AccountInfo.getInstance().getDeveloperKey());

        // Ӧ��Key���������ɽ�ͨ�����ṩ
        initparam.addParam(InitParam.PARAM_KEY_APP_KEY, AccountInfo.getInstance().getAppKey());

        // ��־��·������ѡ�������������Ϊ����������־
        initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_PATH, logPath);

        // ��־��Ŀ��Ĭ�ϱ������ٸ���־�ļ��������򸲸���ɵ���־
        initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_COUNT, "5");

        // ��־��С��Ĭ��һ����־�ļ�д��󣬵�λΪK
        initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_SIZE, "1024");

        // ��־�ȼ���0=�ޣ�1=����2=���棬3=��Ϣ��4=ϸ�ڣ�5=���ԣ�SDK�����С�ڵ���logLevel����־��Ϣ
        initparam.addParam(InitParam.PARAM_KEY_LOG_LEVEL, "5");

        return initparam;
    }

    /**
     * ��ȡ��Ȩ
     * 
     * @return true �ɹ�
     */
    private int checkAuth() {
        // ��ȡϵͳ��Ȩ����ʱ��
        int initResult;
        AuthExpireTime objExpireTime = new AuthExpireTime();
        initResult = HciCloudSys.hciGetAuthExpireTime(objExpireTime);
        if (initResult == HciErrorCode.HCI_ERR_NONE) {
        	// ��ʾ��Ȩ����,���û�����Ҫ��ע��ֵ,�˴�����ɺ���
        	Date date = new Date(objExpireTime.getExpireTime() * 1000);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        	System.out.println("expire time: " + sdf.format(date));

            if (objExpireTime.getExpireTime() * 1000 < System.currentTimeMillis()) {
            	// ��ȡ��Ȩ����, ����ֵΪ������
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
                // �Ѿ��ɹ���ȡ����Ȩ,���Ҿ�����Ȩ�����г����ʱ��(>7��)
               System.out.println("hciCheckAuth success");
               return initResult;
            }
        } else if (initResult == HciErrorCode.HCI_ERR_SYS_AUTHFILE_INVALID) {
        	// �����ȡAuth�ļ�ʧ��(�����һ������,��û����Ȩ�ļ�),��ʼ��ȡ��Ȩ
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
            // ����ʧ��ԭ��,�����SDK�����ĵ���"�����ֶ�ֵ"�еĴ�����ĺ������������
           System.out.println("getAuthExpireTime Error:" + initResult);
           return initResult;
        }
    }
}
