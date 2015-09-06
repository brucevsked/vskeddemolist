package com.vsked.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.FileSystems;  
import java.nio.file.Path; 
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.Binarizer;  
import com.google.zxing.BinaryBitmap;  
import com.google.zxing.DecodeHintType;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.LuminanceSource;  
import com.google.zxing.MultiFormatReader;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.Result;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.common.HybridBinarizer; 

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;


public class QRCodeTest {

	/**
	 * ����ͼ��
	 * 
	 * @throws WriterException
	 * @throws IOException
	 */
	
	public void testEncode() throws WriterException, IOException {
		String filePath = "D://";
		String fileName = "bbkk1.png";
		JSONObject json = new JSONObject();
		json.put(
				"zxing",
				"https://github.com/search?utf8=%E2%9C%93&q=vsked");
		json.put("author", "vsked");
		String content = json.toJSONString();// ����
		int width = 200; // ͼ����
		int height = 200; // ͼ��߶�
		String format = "png";// ͼ������
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
        BarcodeFormat.QR_CODE, width, height, hints);// ���ɾ���
		Path path = FileSystems.getDefault().getPath(filePath, fileName);
		MatrixToImageWriter.writeToPath(bitMatrix, format, path);// ���ͼ��
		System.out.println("����ɹ�.");
	}

	/**
	 * ����ͼ��
	 */
	@Test
	public void testDecode() {
		String filePath = "D://bbkk1.png";
		BufferedImage image;
		try {
			image = ImageIO.read(new File(filePath));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// ��ͼ����н���
			JSONObject content = JSONObject.parseObject(result.getText());
			System.out.println("ͼƬ�����ݣ�	");
			System.out.println("author��	" + content.getString("author"));
			System.out.println("zxing��	" + content.getString("zxing"));
			System.out.println("ͼƬ�и�ʽ��	");
			System.out.println("encode��	" + result.getBarcodeFormat());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
}

