package com.vsked.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import com.vsked.util.SystemUtil;

public class HwpfWriteTest2 {
	public static void main(String[] args) throws Exception {
		//�ļ�д��web-info/classes/Ŀ¼��
		HwpfWriteTest2 t=new HwpfWriteTest2();
		t.testWrite();
		System.out.println("write finish");
	}
	public void testWrite() throws Exception {
		String templatePath = SystemUtil.getSystemPath("templateV12003.doc");
		InputStream is = new FileInputStream(templatePath);
		HWPFDocument doc = new HWPFDocument(is);
		Range range = doc.getRange();
		// ��range��Χ�ڵ�${reportDate}�滻Ϊ��ǰ������
		range.replaceText("${reportDate}",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		range.replaceText("${appleAmt}", "100.00");
		range.replaceText("${bananaAmt}", "200.00");
		range.replaceText("${totalAmt}", "300.00");
		OutputStream os = new FileOutputStream(SystemUtil.getSystemPath("templateV12003Result.doc"));
		// ��doc������������
		doc.write(os);
		this.closeStream(os);
		this.closeStream(is);
	}

	/**
	 * �ر�������
	 * 
	 * @param is
	 */
	private void closeStream(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �ر������
	 * 
	 * @param os
	 */
	private void closeStream(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
