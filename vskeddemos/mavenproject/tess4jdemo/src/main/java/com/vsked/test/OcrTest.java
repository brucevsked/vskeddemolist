package com.vsked.test;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class OcrTest {

     public static void main(String[] args) {  
            File imageFile = new File("D:/tempMission/2/$%~ODF~R%35[`MZ@AX){ONV.jpg");  
            ITesseract instance = new Tesseract();  // JNA Interface Mapping  
            
            try {  
                //读取一个文件夹下的所有图片并验证
                /*    String[] filelist = imageFile.list();
                for (int i = 0; i < filelist.length; i++) {
                        File readfile = new File("E:\\valimg" + "\\" + filelist[i]);
                        if (!readfile.isDirectory()) {
                                System.out.println("path=" + readfile.getPath());
                                System.out.println("absolutepath="
                                                + readfile.getAbsolutePath());
                                System.out.println("name=" + readfile.getName());

                                String result = instance.doOCR(readfile);
                                //String result = instance.doOCR(change(readfile));
                                System.err.println(readfile.getName() +" result："+  result);
                     }
                }*/ 
                 instance.setLanguage("chi_sim"); //加载语言包
                 String result = instance.doOCR(imageFile);
                
                 System.err.println(imageFile.getName() +" result："+  result);
                 
            } catch (TesseractException e) {  
                System.err.println(e.getMessage());  
            }  
     } 
     
     public static BufferedImage change(File file){
         
            // 读取图片字节数组
             BufferedImage textImage = null;
            try {
                 InputStream in = new FileInputStream(file);
                 BufferedImage image = ImageIO.read(in);
                 textImage=ImageHelper.convertImage2Binary(image); //二值 化处理
                 textImage = ImageHelper.convertImageToGrayscale(ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight()));  //灰度处理
                 textImage = ImageHelper.getScaledInstance(image, image.getWidth() * 5, image.getHeight() * 5);  //将图片扩大5倍

            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return textImage;
     }
}
