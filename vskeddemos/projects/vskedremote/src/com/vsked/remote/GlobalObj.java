package com.vsked.remote;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

public class GlobalObj {
	
	private static BASE64Encoder base64enc=null;
	private static Robot robot=null;
	private static Rectangle re = null;
	
	public static BASE64Encoder getBaseEnc(){
		return base64enc==null?new BASE64Encoder():base64enc;
	}
	
	public static String getBase64Data(byte[] dt){
		return getBaseEnc().encode(dt);
	}
	
	public static Robot getRobot(){
		try {
			return robot==null?new Robot():robot;
		} catch (AWTException e) {
			return null;
		}
	}
	
	public static Rectangle getRe(){
		return re==null?new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()):re;
	}
	
	public static String getImg(){
		byte[] b = null;
		ByteArrayOutputStream os=new ByteArrayOutputStream();//新建流。
		BufferedImage bi=getRobot().createScreenCapture(getRe());//BufferedImage对象。
		try {
			ImageIO.write(bi, "png", os);
			b=os.toByteArray();
		} catch (IOException e) {
		}
		return "data:image/jpg;base64,"+getBase64Data(b);
	}
	
}
