package com.vsked.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtil {
	
	private static Logger log = Logger.getLogger(ImageUtil.class);
	
	/**
	 * 将base64编码转换为文件
	 * @param imgStr base64字符串
	 * @param path 文件全路径包括文件名
	 * @return
	 */
	public static boolean base64ToFile(String imgStr, String path) {
		if (imgStr == null) return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try{
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
            out.flush();
            out.close();
            return true;
		}catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 将文件转换为base64编码
	 * @param imgFile 文件名
	 * @return 编码后base64字符串
	 */
	public static String fileToBase64(String imgFile) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgFile);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	       log.error(e.getMessage());
	    }
	    // 加密
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}
	
	/**
	 * 移除data:image/png;base64,类似头部信息
	 * @param imgStr
	 * @return
	 */
	public static String removeBase64Head(String imgStr){
		if(imgStr.indexOf(",")>0){
			return imgStr.substring(imgStr.indexOf(",")+1,imgStr.length());
		}
		return imgStr;
	}

}
