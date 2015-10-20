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
	     * �����û���Ϣ������
	     */
	    AccountInfo mAccountInfo;

	    /**
	     * HciCloud�����࣬���������ϵͳ��ʼ�����ͷŲ�����
	     */
	    HciCloudSysHelper mHciCloudSysHelper;

	    /**
	     * Ocr�����࣬ �����Ocr�����ĳ�ʼ������ʼ�ϳɣ��ͷŲ�����
	     */
	    HciCloudOcrHelper mHciCloudOcrHelper;
	    
        mAccountInfo = AccountInfo.getInstance();
        boolean loadResult = mAccountInfo.loadAccountInfo();
        if (loadResult) {
            // ������Ϣ�ɹ�����������
        	System.out.println("���������˺ųɹ�");
        } else {
            // ������Ϣʧ�ܣ���ʾʧ�ܽ���
        	System.out.println("���������˺�ʧ�ܣ�����assets/AccountInfo.txt�ļ�����д��ȷ�������˻���Ϣ���˻���Ҫ��www.hcicloud.com������������ע�����롣");
            return;
        }

        mHciCloudSysHelper = HciCloudSysHelper.getInstance();
        mHciCloudOcrHelper = HciCloudOcrHelper.getInstance();

        // �˷������߳������ģ����ҽ����н�����زŻ��������ִ�С�
        // �˴�ֻ����ʾ�ϳ������÷���û�жԺ�ʱ�������д�����Ҫ�����߷����̨�߳̽��г�ʼ������
        // �������ȵ���HciCloudSys�ĳ�ʼ������
        int sysInitResult = mHciCloudSysHelper.init();
        if (sysInitResult != HciErrorCode.HCI_ERR_NONE) {
        	System.out.println("hci init error, error code = " + sysInitResult);
            return;
        } else {
        	System.out.println("hci init success");
        }
        
        // �˷������߳������ģ����ҽ����н�����زŻ��������ִ�С�
        // �˴�ֻ����ʾ�ϳ������÷���û�жԺ�ʱ�������д�����Ҫ�����߷����̨�߳̽��г�ʼ������
        // ֻ��HciCloudSys��ʼ���ɹ��󣬲��ܵ���asr�ĳ�ʼ������
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
			nRet = mHciCloudOcrHelper.bizcardRecog("BizCard.jpg"); // ��Ƭʶ��
			if(nRet) {
				System.out.println(" bizcardRecog success��");	
			} else {
				System.out.println(" bizcardRecog failed!");
			}
		} else if (capkey.contains("template")) {
			// ����ģ��ʶ��
			if(capkey.contains("local")) {
				nRet = mHciCloudOcrHelper.templateRecog("IDCard.jpg");// ����ģ��ʶ��
				if(nRet) {
					System.out.println("local templateRecog success!");	
				} else {
					System.out.println("local templateRecog failed��");
				}				
			}
			
			// �ƶ�ģ��ʶ��
			if(capkey.contains("cloud")) {
				nRet = mHciCloudOcrHelper.autoRecog("IDCard.jpg");		//�ƶ�ģ��ʶ��
				if(nRet) {
					System.out.println("cloud templateRecog success��");	
				} else {
					System.out.println("cloud templateRecog failed��");
				}	
			}

		} else {
			// �ı�ʶ��
			nRet = mHciCloudOcrHelper.autoRecog("ocr.jpg"); // �Զ������������бУ��
			if(nRet) {
				System.out.println(" autoRecog success��");	
			} else {
				System.out.println(" autoRecog failed��");
			}
			
			nRet = mHciCloudOcrHelper.advanceRecog("ocr.jpg"); // �ֶ����������������бУ��
			if(nRet) {
				System.out.println(" advanceRecog success��");	
			} else {
				System.out.println(" advanceRecog failed��");
			}
		}
		// -------------����ʼ��------------------------------------------
		// ��ֹOCR����
		int ocrReleaseRet = mHciCloudOcrHelper.release();
		if(HciErrorCode.HCI_ERR_NONE != ocrReleaseRet) {
			System.out.println("hciOcrRelease failed:" + ocrReleaseRet);
		}
		System.out.println("hciOcrRelease Success");

		// ��ֹ ���� ϵͳ
		int sysReleaseRet = mHciCloudSysHelper.release();
		if(HciErrorCode.HCI_ERR_NONE != sysReleaseRet) {
			System.out.println("hciRelease failed:" + sysReleaseRet);
		}
		System.out.println("hciRelease Success");
	}
}
