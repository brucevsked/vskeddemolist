package com.sinovoice.example.ocr;

import com.sinovoice.example.sys.AccountInfo;
import com.sinovoice.example.sys.HciCloudSysHelper;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;

public class HciCloudOcrMain {

	private static String capkey = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    /**
	     * 加载用户信息工具类
	     */
	    AccountInfo mAccountInfo;

	    /**
	     * HciCloud帮助类，可完成灵云系统初始化，释放操作。
	     */
	    HciCloudSysHelper mHciCloudSysHelper;

	    /**
	     * Ocr帮助类， 可完成Ocr能力的初始化，开始合成，释放操作。
	     */
	    HciCloudOcrHelper mHciCloudOcrHelper;
	    
        mAccountInfo = AccountInfo.getInstance();
        boolean loadResult = mAccountInfo.loadAccountInfo();
        if (loadResult) {
            // 加载信息成功进入主界面
        	System.out.println("加载灵云账号成功");
        } else {
            // 加载信息失败，显示失败界面
        	System.out.println("加载灵云账号失败！请在assets/AccountInfo.txt文件中填写正确的灵云账户信息，账户需要从www.hcicloud.com开发者社区上注册申请。");
            return;
        }

        mHciCloudSysHelper = HciCloudSysHelper.getInstance();
        mHciCloudOcrHelper = HciCloudOcrHelper.getInstance();

        // 此方法是线程阻塞的，当且仅当有结果返回才会继续向下执行。
        // 此处只是演示合成能力用法，没有对耗时操作进行处理。需要开发者放入后台线程进行初始化操作
        // 必须首先调用HciCloudSys的初始化方法
        int sysInitResult = mHciCloudSysHelper.init();
        if (sysInitResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("hci init error, error code = " + sysInitResult);
            return;
        } else {
        	System.out.println("hci init success");
        }
        
        // 此方法是线程阻塞的，当且仅当有结果返回才会继续向下执行。
        // 此处只是演示合成能力用法，没有对耗时操作进行处理。需要开发者放入后台线程进行初始化操作
        // 只有HciCloudSys初始化成功后，才能调用asr的初始化方法
        int ocrInitResult = mHciCloudOcrHelper.init();
        if (ocrInitResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("Ocr init failed: " + ocrInitResult);
            return;
        } else {
        	System.out.println("Ocr init success");
        }

        capkey = mAccountInfo.getCapKey();
		boolean nRet = true;		
		if (capkey.contains("bizcard")) {
			nRet = mHciCloudOcrHelper.bizcardRecog("BizCard.jpg"); // 名片识别
			if(nRet) {
				System.out.println(" bizcardRecog success！");	
			} else {
				System.out.println(" bizcardRecog failed!");
			}
		} else if (capkey.contains("template")) {
			// 本地模板识别
			if(capkey.contains("local")) {
				nRet = mHciCloudOcrHelper.templateRecog("IDCard.jpg");// 本地模板识别
				if(nRet) {
					System.out.println("local templateRecog success!");	
				} else {
					System.out.println("local templateRecog failed！");
				}				
			}
			
			// 云端模板识别
			if(capkey.contains("cloud")) {
				nRet = mHciCloudOcrHelper.autoRecog("IDCard.jpg");		//云端模板识别
				if(nRet) {
					System.out.println("cloud templateRecog success！");	
				} else {
					System.out.println("cloud templateRecog failed！");
				}	
			}

		} else {
			// 文本识别
			nRet = mHciCloudOcrHelper.autoRecog("ocr.jpg"); // 自动版面分析和倾斜校正
			if(nRet) {
				System.out.println(" autoRecog success！");	
			} else {
				System.out.println(" autoRecog failed！");
			}
			
			nRet = mHciCloudOcrHelper.advanceRecog("ocr.jpg"); // 手动决定版面分析和倾斜校正
			if(nRet) {
				System.out.println(" advanceRecog success！");	
			} else {
				System.out.println(" advanceRecog failed！");
			}
		}
		// -------------反初始化------------------------------------------
		// 终止OCR能力
		int ocrReleaseRet = mHciCloudOcrHelper.release();
		if(HciErrorCode.HCI_ERR_NONE != ocrReleaseRet) {
			System.out.println("hciOcrRelease failed:" + ocrReleaseRet);
		}
		System.out.println("hciOcrRelease Success");

		// 终止 灵云 系统
		int sysReleaseRet = mHciCloudSysHelper.release();
		if(HciErrorCode.HCI_ERR_NONE != sysReleaseRet) {
			System.out.println("hciRelease failed:" + sysReleaseRet);
		}
		System.out.println("hciRelease Success");
	}
}
