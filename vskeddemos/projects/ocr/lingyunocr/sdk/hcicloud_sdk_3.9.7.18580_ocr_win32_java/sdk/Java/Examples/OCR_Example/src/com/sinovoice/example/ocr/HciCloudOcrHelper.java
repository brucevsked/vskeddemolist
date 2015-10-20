package com.sinovoice.example.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.sinovoice.example.sys.AccountInfo;
import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.api.ocr.HciCloudOcr;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.ocr.OcrInitParam;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogDeskewResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogLayoutAnalysisResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogNode;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogRegion;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrTemplateId;

public class HciCloudOcrHelper {
	String sPath = System.getProperty("user.dir");
    private String mCapKey = AccountInfo.getInstance().getCapKey();
    private static HciCloudOcrHelper mInstance;
    
    static {
		// ����sdk��dll�ļ�Ŀ¼
		String libPath = System.getProperty("user.dir") + "\\libs";
		// ָ��dll�ļ�·����˳���ʾ����˳��
		String ocrLibPath[] = new String[] { libPath + "\\libcurl.dll",
				libPath + "\\hci_sys.dll", libPath + "\\hci_ocr.dll",
				libPath + "\\hci_ocr_jni.dll",
				libPath + "\\hci_ocr_cloud_recog.dll",
				libPath + "\\hci_ocr_local_recog.dll", 
				libPath + "\\hci_ocr_local_recog_bizcard.dll",
				libPath + "\\hci_ocr_local_recog_template.dll",		
				};
		// �ټ���hci_ocr.dll
		HciLibPath.setOcrLibPath(ocrLibPath);
    }
    
	private static final String[] mRegionType = { "HORZ", "VERT", "TABLE",
			"GRAPH", "AUTOTEXT" };
	private static final String[] mNodeType = { "PAGE", "RGN ", "CELL", "LINE",
			"CHAR" };
	private static final String[] mLangType = { "default", "zh-cn", "zh-hk",
			"zh-tw", "english" };
	
    private HciCloudOcrHelper() {
    }
    
	public static HciCloudOcrHelper getInstance() {
		if (mInstance == null) {
			mInstance = new HciCloudOcrHelper();
		}
		return mInstance;
	}

	/**
     *  ocr�ĳ�ʼ������
     */
	public int init() {

		// ����Ocr��ʼ���İ������ʵ��
		OcrInitParam ocrInitParam = new OcrInitParam();
		
        String dataPath = sPath + "\\data";
        ocrInitParam.addParam(ocrInitParam.PARAM_KEY_DATA_PATH, dataPath);
        ocrInitParam.addParam(ocrInitParam.PARAM_KEY_FILE_FLAG, "none");
        ocrInitParam.addParam(ocrInitParam.PARAM_KEY_INIT_CAP_KEYS, mCapKey);
        
        // ���ó�ʼ������
        int initResult = HciCloudOcr.hciOcrInit(ocrInitParam.getStringConfig());

        return initResult;
	}

	/**
     *  Ocr����ʼ��
     */
	public int release() {
		int nRet = HciCloudOcr.hciOcrRelease();

		return nRet;
	}

	/**
	 * �ƶ˸߼�ʶ��,�û����е�����б�����Ͱ������
	 * @param data ͼ��Ķ���������
	 */
	public boolean advanceRecog(String fileNameString) {
		System.out.println("advanceRecog start...");
		
		byte[] data = getAssetFileData(fileNameString);
		if(null == data) {
			System.out.println("Open input voice file" + fileNameString + "error!");
			return false;
		}
		
		// ���� OCR Session
		String sSessionConfig = "capkey=" + mCapKey;
		System.out.println("HciCloudOcr hciOcrSessionStart config=" + sSessionConfig);

		Session nSessionId = new Session();
		int errCode = HciCloudOcr.hciOcrSessionStart(sSessionConfig, nSessionId);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSessionStart failed: " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStart Success");

		errCode = HciCloudOcr.hciOcrSetImageBuffer(nSessionId, data);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSetImageBuffer failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSetImageBuffer Success");
		
		// ��бУ��
		System.out.println("deskew start...");
		
		// ��������ͼƬΪ����ͼƬ��������Ӳ���imageType=screen �� ����ʶ��Ч����������Ĭ�ϲ���ΪimageType=normal
		// ��ȡ��б��������Ķ���
		OcrRecogDeskewResult ocrDeskewResult = new OcrRecogDeskewResult();

		// ��ʼ����������Ĭ�ϲ���ȫ������ΪĬ��ֵ
		errCode = HciCloudOcr.hciOcrDeskew(nSessionId, null, ocrDeskewResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrDeskew failed:" + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrDeskew success");

		// �������
		System.out.println("analysis start...");
		OcrRecogLayoutAnalysisResult ocrLayoutResult = new OcrRecogLayoutAnalysisResult();

		// �������
		// ��ʼ�������,�������ò��������, ѡ��Ĭ��
		errCode = HciCloudOcr.hciOcrLayoutAnalysis(nSessionId, null, ocrLayoutResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrLayoutAnalysis failed:" + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrLayoutAnalysis success");


		System.out.println("recog start.");
		
		// ���ò���
		String strRecogConfig = "detailresult=yes,recogrange=all";
		
		// ��������Ľ��Ҫ��Ϊ�������ݸ�ʶ�𷽷�
		ArrayList<OcrRecogRegion> ocrlayoutResultList = ocrLayoutResult.getRecogRegionList();

		OcrRecogResult recogResult = new OcrRecogResult();
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, ocrlayoutResultList, recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed:" + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");

		// �����ϸ��Ϣ
		outPutRecogResult(recogResult);

		// �رջỰ
		errCode = HciCloudOcr.hciOcrSessionStop(nSessionId);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrSessionStop failed:" + errCode);
			return false;
		}
		
		System.out.println("advanceRecog leave...");
		return true;
	}

	public boolean autoRecog(String fileNameString) {
		System.out.println("autoRecog start...");
		
		byte[] data = getAssetFileData(fileNameString);
		if(null == data) {
			System.out.println("Open input voice file" + fileNameString + "error!");
			return false;
		}
		
		// ���� OCR Session
		String sSessionConfig = "capkey=" + mCapKey;
		System.out.println("HciCloudOcr hciOcrSessionStart config: " + sSessionConfig);
		Session nSessionId = new Session();
		
		int errCode = HciCloudOcr.hciOcrSessionStart(sSessionConfig, nSessionId);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSessionStart return " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStart Success");

		// --------------------------���뱾�λỰ��ͼ���ڴ�-------------------------------------

		errCode = HciCloudOcr.hciOcrSetImageBuffer(nSessionId, data);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSetImageBuffer failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSetImageBuffer Success");

		String strRecogConfig = "";
		if(mCapKey.contains("cloud.template")) {
			strRecogConfig = "cutedge=no,domain=idcard,templateIndex=0,templatePageIndex=0";
		} else {
			strRecogConfig = "autodeskew=yes,autolayout=yes,detailresult=yes,recogrange=all";
		}
		
		/*
		 * ��������ͼƬΪ����ͼƬ��������Ӳ���imageType=screen
		 * ����ʶ��Ч����������Ĭ�ϲ���ΪimageType=normal
		 */
		OcrRecogResult recogResult = new OcrRecogResult();
		// ��ʼʶ��, ���ڲ�ָ��ʶ������,��������������NULL
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, null, recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");
		
		System.out.println("AutoRecog result: " + recogResult.getResultText());

		// �رջỰ
		errCode = HciCloudOcr.hciOcrSessionStop(nSessionId);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("hciOcrSessionStop failed: " + errCode);
			return false;
		}

		System.out.println("autoRecog leave...");
		return true;
	}
	
	public boolean bizcardRecog(String fileNameString) {
		System.out.println("bizcardRecog start...");

		byte[] data = getAssetFileData(fileNameString);
		if(null == data) {
			System.out.println("Open input voice file" + fileNameString + "error!");
			return false;
		}
		
		// ���� OCR Session
		String sSessionConfig = "capkey=" + mCapKey;
		System.out.println("HciCloudOcr hciOcrSessionStart config: " + sSessionConfig);
		Session nSessionId = new Session();
		int errCode = HciCloudOcr.hciOcrSessionStart(sSessionConfig, nSessionId);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSessionStart return " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStart Success");
		
		// --------------------------���뱾�λỰ��ͼ���ڴ�-------------------------------------------------------------
		errCode = HciCloudOcr.hciOcrSetImageBuffer(nSessionId, data);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrSetImageBuffer failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSetImageBuffer Success");
		
		// ʶ��������ע��cutEdge������,���ͼ���Ѿ����б�ͼ��������Ϊno��������Բ���Ĭ��ֵyes
		String strRecogConfig = "cutedge=yes";
		OcrRecogResult recogResult = new OcrRecogResult();
		// ��ʼʶ��, ���ڲ�ָ��ʶ������,��������������NULL
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, null, recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");
		
		System.out.println("bizcardRecog result: " + recogResult.getResultText());

		// �رջỰ
		errCode = HciCloudOcr.hciOcrSessionStop(nSessionId);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrSessionStop failed: " + errCode);
			return false;
		}

		System.out.println("bizcardRecog leave...");
		return true;
	}
	
	public boolean templateRecog(String fileNameString) {	
		System.out.println("templateRecog start...");
		
		byte[] data = getAssetFileData(fileNameString);
		if(null == data) {
			System.out.println("Open input voice file" + fileNameString + "error!");
			return false;
		}
		
		int errCode = 0;
		OcrTemplateId templateId = new OcrTemplateId();		
		
		String ocrTemplatePath = sPath + "\\data\\templates\\IdCard\\IDCard_EN.xml";

		if (mCapKey.contains("ocr.local.template")) {
			// ����ģ��ʶ����Ҫ�ֶ�����ģ���ļ�
			errCode = HciCloudOcr.hciOcrLoadTemplate(ocrTemplatePath, templateId);
			if (errCode != HciErrorCode.HCI_ERR_NONE) {
				System.out.println("load template failed: " + errCode);
				return false;
			}
			System.out.println("load template success");
		} else {
			// �˴�ָ��ģ��IDΪ1����Ҫ����ʵ�ʷ����������ģ����������趨
			templateId.setTemplateId(1);
		}

		String sSessionConfig = "capkey=" + mCapKey;
		sSessionConfig += ",templateid=" + templateId.getTemplateId();
		Session nSessionId = new Session();
		System.out.println("HciCloudOcr hciOcrSessionStart config: " + sSessionConfig);

		errCode = HciCloudOcr.hciOcrSessionStart(sSessionConfig, nSessionId);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSessionStart failed: " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStart Success");

		errCode = HciCloudOcr.hciOcrSetImageBuffer(nSessionId, data);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrSetImageBuffer failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSetImageBuffer Success");
		
		// ʶ��������ע��cutEdge������,���ͼ���Ѿ����б�ͼ��������Ϊno��������Բ���Ĭ��ֵyes
		// ģ����Ϣ���òο������ֲ��ж�ģ���ļ���˵��
		String strRecogConfig = "templateIndex=0,templatePageIndex=0,cutedge=no";
		OcrRecogResult recogResult = new OcrRecogResult();
		// ��ʼʶ��, ���ڲ�ָ��ʶ������,��������������NULL
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, null,recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");
		
		System.out.println("templateRecog result: " + recogResult.getResultText());
		
		// �رջỰ
		errCode = HciCloudOcr.hciOcrSessionStop(nSessionId);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("hciOcrSessionStop failed: " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStop success");
		
		if (mCapKey.contains("ocr.local.template")) {
			errCode = HciCloudOcr.hciOcrUnloadTemplate(templateId);
			if (errCode != HciErrorCode.HCI_ERR_NONE) {
				System.out.println("unLoad Template failed: " + errCode);
				return false;
			}
			System.out.println("HciCloudOcr hciOcrUnloadTemplate success");
		}
		
		System.out.println("templateRecog leave...");
		return true;
	}
	
	/**
	 * ��ȡָ��Assert�ļ��е�����
	 * 
	 * @param fileName
	 * @return
	 */
	private byte[] getAssetFileData(String fileName) {
		String file = sPath + "\\testdata\\" + fileName;
		File fileSrc = new File(file);
		if (!fileSrc.exists())
			return null;
		
		int size = (int)fileSrc.length();
		try {
			FileInputStream rd = new FileInputStream(fileSrc);
			byte[] data = new byte[size];
			
			rd.read(data);
			
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * ���ʶ����
	 * 
	 * @param recogResult
	 *            ʶ��������
	 */
	private void outPutRecogResult(OcrRecogResult recogResult) {
		if (recogResult == null) {
			System.out.println("recogResult is null.");
			return;
		}

		System.out.println("RecogResultText=" + recogResult.getResultText());		

		ArrayList<OcrRecogNode> arrayResult = recogResult.getNodeList();
		if (arrayResult == null) {
			System.out.println("OcrRecogNodeList is null.");
			return;
		}

		for (int i = 0; i < arrayResult.size(); i++) {
			// ʶ�����ڵ�����
			OcrRecogNode recogNode = arrayResult.get(i);
			int nodeType = recogNode.getNodeType();
			System.out.println(mNodeType[nodeType] + ": ");
			if (HciCloudOcr.OCR_RECOG_NODE_PAGE == nodeType) {
				// ҳ����
				System.out.println("(" + recogNode.getPageNode().getWidth() + " x "
						+ recogNode.getPageNode().getHeight() + ") Skew: "
						+ recogNode.getPageNode().getDeskewAngle());
			} else if (HciCloudOcr.OCR_RECOG_NODE_REGION == nodeType) {
				// ��������
				System.out.println(mRegionType[recogNode.getRegionNode()
						.getRegionType()]);

				// �������������ͼ���λ��
				System.out.println(" ("
						+ recogNode.getRegionNode().getRegionRect().left + ", "
						+ recogNode.getRegionNode().getRegionRect().top + ", "
						+ recogNode.getRegionNode().getRegionRect().right
						+ ", "
						+ recogNode.getRegionNode().getRegionRect().bottom
						+ ")");
				// �����ʵ��ʶ������
				System.out.println(" Lang: "
						+ mLangType[recogNode.getRegionNode().getRegionType()]);
			} else if (HciCloudOcr.OCR_RECOG_NODE_CELL == nodeType) {
				// �˱��Ԫ��λ��
				System.out.println("(" + recogNode.getCellNode().getCellRect().left
						+ ", " + recogNode.getCellNode().getCellRect().top
						+ ", " + recogNode.getCellNode().getCellRect().right
						+ ", " + recogNode.getCellNode().getCellRect().bottom
						+ ")");
			} else if (HciCloudOcr.OCR_RECOG_NODE_LINE == nodeType) {
				// ���еĻ���
				System.out.println("baseline: " + recogNode.getLineNode().getBaseLine()
						+ " height:" + recogNode.getLineNode().getLineSize()
						+ " avgCharSize: " + recogNode.getLineNode().getXChar()
						+ " x " + recogNode.getLineNode().getYChar());
			} else if (HciCloudOcr.OCR_RECOG_NODE_CHAR == nodeType) {
				// �Ƿ����
				System.out.println(recogNode.getCharNode().isAccept() ? " " : "*");
				// ʶ��������
				if (recogNode.getCharNode().getChar() != null) {
					System.out.println(recogNode.getCharNode().getChar());
				}

				// �����ѡ�ֵ�ʶ����
				System.out.println("[");
				final int CANDIDATE_NUM = 5;
				for (int j = 0; j < CANDIDATE_NUM; j++) {
					System.out.println(recogNode.getCharNode().getCandidateWords().get(j));
				}
				System.out.println("]");

				// ���ַ���ͼ��������
				System.out.println(" (" + recogNode.getCharNode().getImageRect().left
						+ ", " + recogNode.getCharNode().getImageRect().top
						+ ", " + recogNode.getCharNode().getImageRect().bottom
						+ ", " + recogNode.getCharNode().getImageRect().right
						+ ")");

				// �ַ�ǰ��Ŀո��ַ���
				if (recogNode.getCharNode().getSpaceBefore() != 0) {
					System.out.println("LeadingSpace: " + recogNode.getCharNode().getSpaceBefore());
				}
			}
			System.out.println("");
		}
	}
	
}
