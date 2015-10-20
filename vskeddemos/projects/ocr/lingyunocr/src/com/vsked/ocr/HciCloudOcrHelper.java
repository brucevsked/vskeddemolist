package com.vsked.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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
import com.vsked.entity.AccountInfo;
import com.vsked.util.FileUtil;

public class HciCloudOcrHelper {
    private String mCapKey = AccountInfo.getInstance().getCapKey();
    private static HciCloudOcrHelper mInstance;
    
    static {
		// 灵云sdk中dll文件目录
		String libPath = FileUtil.getBasePath()+"../" + "lib";
		// 指定dll文件路径，顺序表示加载顺序
		String ocrLibPath[] = new String[] { libPath + "\\libcurl.dll",
				libPath + "\\hci_sys.dll", libPath + "\\hci_ocr.dll",
				libPath + "\\hci_ocr_jni.dll",
				libPath + "\\hci_ocr_cloud_recog.dll",
				libPath + "\\hci_ocr_local_recog.dll", 
				libPath + "\\hci_ocr_local_recog_bizcard.dll",
				libPath + "\\hci_ocr_local_recog_template.dll",		
				};
		// 再加载hci_ocr.dll
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
     *  ocr的初始化方法
     */
	public int init(String basePath) {

		// 构造Ocr初始化的帮助类的实例
		OcrInitParam ocrInitParam = new OcrInitParam();
		
        String dataPath = basePath + "data";
        ocrInitParam.addParam(ocrInitParam.PARAM_KEY_DATA_PATH, dataPath);
        ocrInitParam.addParam(ocrInitParam.PARAM_KEY_FILE_FLAG, "none");
        ocrInitParam.addParam(ocrInitParam.PARAM_KEY_INIT_CAP_KEYS, mCapKey);
        
        // 调用初始化方法
        int initResult = HciCloudOcr.hciOcrInit(ocrInitParam.getStringConfig());

        return initResult;
	}

	/**
     *  Ocr反初始化
     */
	public int release() {
		int nRet = HciCloudOcr.hciOcrRelease();

		return nRet;
	}

	/**
	 * 云端高级识别,用户自行调用倾斜矫正和版面分析
	 * @param data 图像的二进制数据
	 */
	public boolean advanceRecog(String fileNameString) {
		System.out.println("advanceRecog start...");
		
		byte[] data = getAssetFileData(fileNameString);
		if(null == data) {
			System.out.println("Open input voice file" + fileNameString + "error!");
			return false;
		}
		
		// 启动 OCR Session
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
		
		// 倾斜校正
		System.out.println("deskew start...");
		
		// 如果传入的图片为截屏图片，可以添加参数imageType=screen ， 会有识别效果的提升，默认参数为imageType=normal
		// 获取倾斜矫正结果的对象
		OcrRecogDeskewResult ocrDeskewResult = new OcrRecogDeskewResult();

		// 开始矫正，传入默认参数全部设置为默认值
		errCode = HciCloudOcr.hciOcrDeskew(nSessionId, null, ocrDeskewResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrDeskew failed:" + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrDeskew success");

		// 版面分析
		System.out.println("analysis start...");
		OcrRecogLayoutAnalysisResult ocrLayoutResult = new OcrRecogLayoutAnalysisResult();

		// 添加数据
		// 开始版面分析,分析配置参数传入空, 选择默认
		errCode = HciCloudOcr.hciOcrLayoutAnalysis(nSessionId, null, ocrLayoutResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrLayoutAnalysis failed:" + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrLayoutAnalysis success");


		System.out.println("recog start.");
		
		// 配置参数
		String strRecogConfig = "detailresult=yes,recogrange=all";
		
		// 版面分析的结果要作为参数传递给识别方法
		ArrayList<OcrRecogRegion> ocrlayoutResultList = ocrLayoutResult.getRecogRegionList();

		OcrRecogResult recogResult = new OcrRecogResult();
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, ocrlayoutResultList, recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed:" + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");

		// 输出详细信息
		outPutRecogResult(recogResult);

		// 关闭会话
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
		
		// 启动 OCR Session
		String sSessionConfig = "capkey=" + mCapKey;
		System.out.println("HciCloudOcr hciOcrSessionStart config: " + sSessionConfig);
		Session nSessionId = new Session();
		
		int errCode = HciCloudOcr.hciOcrSessionStart(sSessionConfig, nSessionId);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSessionStart return " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStart Success");

		// --------------------------载入本次会话的图像到内存-------------------------------------

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
		 * 如果传入的图片为截屏图片，可以添加参数imageType=screen
		 * 会有识别效果的提升，默认参数为imageType=normal
		 */
		OcrRecogResult recogResult = new OcrRecogResult();
		// 开始识别, 由于不指定识别区域,第三个参数传入NULL
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, null, recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");
		
		System.out.println("AutoRecog result: " + recogResult.getResultText());

		// 关闭会话
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
		
		// 启动 OCR Session
		String sSessionConfig = "capkey=" + mCapKey;
		System.out.println("HciCloudOcr hciOcrSessionStart config: " + sSessionConfig);
		Session nSessionId = new Session();
		int errCode = HciCloudOcr.hciOcrSessionStart(sSessionConfig, nSessionId);
		if (HciErrorCode.HCI_ERR_NONE != errCode) {
			System.out.println("HciCloudOcr hciOcrSessionStart return " + errCode);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSessionStart Success");
		
		// --------------------------载入本次会话的图像到内存-------------------------------------------------------------
		errCode = HciCloudOcr.hciOcrSetImageBuffer(nSessionId, data);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrSetImageBuffer failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrSetImageBuffer Success");
		
		// 识别配置中注意cutEdge的配置,如果图像已经是切边图像则设置为no，否则可以采用默认值yes
		String strRecogConfig = "cutedge=yes";
		OcrRecogResult recogResult = new OcrRecogResult();
		// 开始识别, 由于不指定识别区域,第三个参数传入NULL
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, null, recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");
		
		System.out.println("bizcardRecog result: " + recogResult.getResultText());

		// 关闭会话
		errCode = HciCloudOcr.hciOcrSessionStop(nSessionId);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrSessionStop failed: " + errCode);
			return false;
		}

		System.out.println("bizcardRecog leave...");
		return true;
	}
	
	public boolean templateRecog(String fileNameString,String xmlFilePath) {	
		System.out.println("templateRecog start...");
		
		byte[] data = getAssetFileData(fileNameString);
		if(null == data) {
			System.out.println("Open input voice file" + fileNameString + "error!");
			return false;
		}
		
		int errCode = 0;
		OcrTemplateId templateId = new OcrTemplateId();		
		
		String ocrTemplatePath = xmlFilePath;

		if (mCapKey.contains("ocr.local.template")) {
			// 本地模板识别需要手动加载模板文件
			errCode = HciCloudOcr.hciOcrLoadTemplate(ocrTemplatePath, templateId);
			if (errCode != HciErrorCode.HCI_ERR_NONE) {
				System.out.println("load template failed: " + errCode);
				return false;
			}
			System.out.println("load template success");
		} else {
			// 此处指定模板ID为1，需要根据实际服务器部署的模板情况进行设定
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
		
		// 识别配置中注意cutEdge的配置,如果图像已经是切边图像则设置为no，否则可以采用默认值yes
		// 模板信息配置参考开发手册中对模板文件的说明
		String strRecogConfig = "templateIndex=0,templatePageIndex=0,cutedge=no";
		OcrRecogResult recogResult = new OcrRecogResult();
		// 开始识别, 由于不指定识别区域,第三个参数传入NULL
		errCode = HciCloudOcr.hciOcrRecog(nSessionId, strRecogConfig, null,recogResult);
		if (errCode != HciErrorCode.HCI_ERR_NONE) {
			System.out.println("HciCloudOcr hciOcrRecog failed: " + errCode);
			HciCloudOcr.hciOcrSessionStop(nSessionId);
			return false;
		}
		System.out.println("HciCloudOcr hciOcrRecog success");
		
		System.out.println("templateRecog result: " + recogResult.getResultText());
		
		// 关闭会话
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
	 * 获取指定Assert文件中的数据
	 * 
	 * @param fileName
	 * @return
	 */
	private byte[] getAssetFileData(String fileName) {
		String file =  fileName;
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
	 * 输出识别结果
	 * 
	 * @param recogResult
	 *            识别结果对象
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
			// 识别结果节点类型
			OcrRecogNode recogNode = arrayResult.get(i);
			int nodeType = recogNode.getNodeType();
			System.out.println(mNodeType[nodeType] + ": ");
			if (HciCloudOcr.OCR_RECOG_NODE_PAGE == nodeType) {
				// 页面宽带
				System.out.println("(" + recogNode.getPageNode().getWidth() + " x "
						+ recogNode.getPageNode().getHeight() + ") Skew: "
						+ recogNode.getPageNode().getDeskewAngle());
			} else if (HciCloudOcr.OCR_RECOG_NODE_REGION == nodeType) {
				// 区域类型
				System.out.println(mRegionType[recogNode.getRegionNode()
						.getRegionType()]);

				// 区域相对于整个图像的位置
				System.out.println(" ("
						+ recogNode.getRegionNode().getRegionRect().left + ", "
						+ recogNode.getRegionNode().getRegionRect().top + ", "
						+ recogNode.getRegionNode().getRegionRect().right
						+ ", "
						+ recogNode.getRegionNode().getRegionRect().bottom
						+ ")");
				// 区域的实际识别语言
				System.out.println(" Lang: "
						+ mLangType[recogNode.getRegionNode().getRegionType()]);
			} else if (HciCloudOcr.OCR_RECOG_NODE_CELL == nodeType) {
				// 此表格单元的位置
				System.out.println("(" + recogNode.getCellNode().getCellRect().left
						+ ", " + recogNode.getCellNode().getCellRect().top
						+ ", " + recogNode.getCellNode().getCellRect().right
						+ ", " + recogNode.getCellNode().getCellRect().bottom
						+ ")");
			} else if (HciCloudOcr.OCR_RECOG_NODE_LINE == nodeType) {
				// 此行的基线
				System.out.println("baseline: " + recogNode.getLineNode().getBaseLine()
						+ " height:" + recogNode.getLineNode().getLineSize()
						+ " avgCharSize: " + recogNode.getLineNode().getXChar()
						+ " x " + recogNode.getLineNode().getYChar());
			} else if (HciCloudOcr.OCR_RECOG_NODE_CHAR == nodeType) {
				// 是否可信
				System.out.println(recogNode.getCharNode().isAccept() ? " " : "*");
				// 识别结果单字
				if (recogNode.getCharNode().getChar() != null) {
					System.out.println(recogNode.getCharNode().getChar());
				}

				// 多个候选字的识别结果
				System.out.println("[");
				final int CANDIDATE_NUM = 5;
				for (int j = 0; j < CANDIDATE_NUM; j++) {
					System.out.println(recogNode.getCharNode().getCandidateWords().get(j));
				}
				System.out.println("]");

				// 此字符在图像中区域
				System.out.println(" (" + recogNode.getCharNode().getImageRect().left
						+ ", " + recogNode.getCharNode().getImageRect().top
						+ ", " + recogNode.getCharNode().getImageRect().bottom
						+ ", " + recogNode.getCharNode().getImageRect().right
						+ ")");

				// 字符前面的空格字符数
				if (recogNode.getCharNode().getSpaceBefore() != 0) {
					System.out.println("LeadingSpace: " + recogNode.getCharNode().getSpaceBefore());
				}
			}
			System.out.println("");
		}
	}
	
}
