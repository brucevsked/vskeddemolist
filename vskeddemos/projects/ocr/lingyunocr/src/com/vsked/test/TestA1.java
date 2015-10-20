package com.vsked.test;

import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.vsked.entity.AccountInfo;
import com.vsked.ocr.HciCloudOcrHelper;
import com.vsked.ocr.HciCloudSysHelper;
import com.vsked.util.FileUtil;


public class TestA1 {

	public static void main(String[] args) {
		String basePath="";
		String accountFilePath="";
		String capkey = null;
		String userInfoPath="";
		String xmlFilePath="";
		String sourceFileName="";
		
		basePath=FileUtil.getBasePath();
		
		accountFilePath=basePath+"data/AccountInfo.txt";
		
		userInfoPath=basePath+"data";
		
		xmlFilePath=basePath+"data/templates/IdCard/IDCard_EN.xml";
		//TODO fixed the path
		sourceFileName=basePath+"sCardPic/IDCard.jpg";
		
		//用户信息
		AccountInfo mAccountInfo;
		//HciCloud帮助类，可完成灵云系统初始化，释放操作。
		HciCloudSysHelper mHciCloudSysHelper;
		//Ocr帮助类， 可完成Ocr能力的初始化，开始合成，释放操作。
		HciCloudOcrHelper mHciCloudOcrHelper;
		
		mAccountInfo = AccountInfo.getInstance();
		boolean loadResult = mAccountInfo.loadAccountInfo(accountFilePath);
		
		
		capkey = mAccountInfo.getCapKey();
		
		System.out.println(loadResult?"加载账号成功":"加载账号失败");
		
        mHciCloudSysHelper = HciCloudSysHelper.getInstance();
        mHciCloudOcrHelper = HciCloudOcrHelper.getInstance();
       
        
        // 此方法是线程阻塞的，当且仅当有结果返回才会继续向下执行。
        // 此处只是演示合成能力用法，没有对耗时操作进行处理。需要开发者放入后台线程进行初始化操作
        // 必须首先调用HciCloudSys的初始化方法
        int sysInitResult = mHciCloudSysHelper.init(userInfoPath);
        
        if (sysInitResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("hci init error, error code = " + sysInitResult);
        }
        

        // 此方法是线程阻塞的，当且仅当有结果返回才会继续向下执行。
        // 此处只是演示合成能力用法，没有对耗时操作进行处理。需要开发者放入后台线程进行初始化操作
        // 只有HciCloudSys初始化成功后，才能调用asr的初始化方法
        int ocrInitResult = mHciCloudOcrHelper.init(basePath);
        if (ocrInitResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("Ocr init failed: " + ocrInitResult);
        } 
        
        boolean nRet = true;
		// 本地模板识别
		if(capkey.contains("local")) {
			nRet = mHciCloudOcrHelper.templateRecog(sourceFileName,xmlFilePath);// 本地模板识别
			if(nRet) {
				System.out.println("local templateRecog success!");	
			} else {
				System.out.println("local templateRecog failed！");
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
