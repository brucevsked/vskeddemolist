package com.vsked.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;


public class ImageUtil {
	
	/**
	 * 将base64编码转换为文件
	 * @param imgStr base64字符串
	 * @param path 文件全路径包括文件名
	 * @return
	 */
	public static boolean base64ToFile(String imgStr, String path) {
		if (imgStr == null) return false;
		try{
			byte[] b = Base64.decodeBase64(imgStr);
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
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将文件转换为base64编码
	 * @param imgFile 文件名
	 * @return 编码后base64字符串
	 */
	public static String fileToBase64(String imgFile) throws Exception{
	    InputStream inputStream  = new FileInputStream(imgFile);
	    byte[] data  = new byte[inputStream.available()];
	    inputStream.read(data);
	    inputStream.close();
	    return Base64.encodeBase64String(data);
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
	
	/**
	 * 提取出base64图片格式data:image/png;base64
	 * @param imgStr
	 * @return 返回base64编码中图片格式如果没有将返回jpg
	 */
	public static String getBase64ImageType(String imgStr){
		int c1=imgStr.indexOf("/");
		int c2=imgStr.indexOf(";");
		if(c1>0 && c2>0){
			return imgStr.substring(c1+1,c2);
		}
		return "jpg";
	}
	
	/**
	 * 获取文件中文件格式
	 * @param fileName
	 * @return 有时将返回图片格式。没有时返回jpg
	 */
	public static String getFileImageType(String fileName){
		int c1=fileName.lastIndexOf(".");
		if(c1>0){
			return fileName.substring(c1+1);
		}
		return "jpg";
	}
	
	/**
	 * 图片二值化 比如验证码识别需要用到
	 * @param oldPath 旧文件路径
	 * @param newPath 新文件路径
	 * @param fileType 文件类型不带点如jpg
	 * @return
	 */
	public static String binaryImage(String oldPath,String newPath,String fileType){
		try{
		File file = new File(oldPath);
	    BufferedImage image = ImageIO.read(file);
	    int width = image.getWidth();
	    int height = image.getHeight();
	    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
	    for(int i= 0 ; i < width ; i++){
	        for(int j = 0 ; j < height; j++){  
	        int rgb = image.getRGB(i, j);
	        grayImage.setRGB(i, j, rgb);
	        }
	    }
	    File newFile = new File(newPath);
	    ImageIO.write(grayImage, fileType, newFile);  
		}catch(Exception e){
			e.printStackTrace();
		}
		return newPath;
	}

}
