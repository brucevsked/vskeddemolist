package com.vsked.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class FileProcess {
	public static void main(String[] args) throws Exception {
		String s="fft";
		writeFile("c:/f.txt", s);
	}
	public static void writeFile(String saveFilePath,String fileContent) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024); 
		FileOutputStream outf = new FileOutputStream(saveFilePath);
		FileChannel fc=outf.getChannel();
		Charset cs = Charset.forName("utf-8");  
		for(int i=0;i<fileContent.length();i++){
			buffer.put(new String(fileContent.charAt(i)+"").getBytes());
			buffer.flip();
			fc.write(buffer);
			buffer.clear(); 
		}
		
	}
	public static String readFile(File inF) throws Exception{
		String str="";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inF.getCanonicalPath())));  
		String data = null;  
		while((data = br.readLine())!=null)  
			str+=data+System.getProperty("line.separator");
		return str;
	}
	

	public static boolean createFolder(String inFolderName){
		File f=	new File(inFolderName);
		return ((!f.exists())&&(!f.isDirectory()))?f.mkdir():false;
	}
	

	public static void writeToFile(BufferedImage inputBufferedImage,String strFileFormat,File f) throws Exception{
		ImageIO.write(inputBufferedImage, strFileFormat, f);
	}
	
	
	public static void writeJPEG(BufferedImage image, String path) throws Exception {       
		FileOutputStream out = new FileOutputStream(path);   
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);        
		encoder.encode(image);        
		out.close();    
    }
	

	public static void writeToFile(RenderedImage inputRenderImage, String strImageFileExt, String inputPath) throws Exception{
		FileOutputStream fos = new FileOutputStream(inputPath);        
		ImageIO.write(inputRenderImage, strImageFileExt, fos);        
		fos.flush();        
		fos.close();
	}
	
	
	public static String getFileChoosePath() throws Exception{
		JFileChooser jc=new JFileChooser();
		jc.showOpenDialog(null);
		if(jc.getSelectedFile()!=null)
		    return jc.getSelectedFile().getCanonicalPath();
		else 
			return "";
	}
	
	public static String get_charset(File file) throws Exception {   
        String charset = "GBK";   
        byte[] first3Bytes = new byte[3];   
        boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );   
            bis.mark( 0 );   
            int read = bis.read( first3Bytes, 0, 3 );   
            if ( read == -1 ) return charset;   
           
			if ( first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE ) {   
                charset = "UTF-16LE";   
                checked = true;   
            }   
            else if ( first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF ) {   
                charset = "UTF-16BE";   
                checked = true;   
            }   
            else if ( first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB && first3Bytes[2] == (byte) 0xBF ) {   
                charset = "UTF-8";   
                checked = true;   
            }   
            bis.reset();   
            if ( !checked ) {   
                int loc = 0;   
  
                while ( (read = bis.read()) != -1 ) {   
                    loc++;   
                    if ( read >= 0xF0 ) break;   
                    if ( 0x80 <= read && read <= 0xBF ) 
                    break;   
                    if ( 0xC0 <= read && read <= 0xDF ) {   
                        read = bis.read();   
                        if ( 0x80 <= read && read <= 0xBF ) 
                                                                        
                        continue;   
                        else break;   
                    }   
                    else if ( 0xE0 <= read && read <= 0xEF ) {
                        read = bis.read();   
                        if ( 0x80 <= read && read <= 0xBF ) {   
                            read = bis.read();   
                            if ( 0x80 <= read && read <= 0xBF ) {   
                                charset = "UTF-8";   
                                break;   
                            }   
                            else break;   
                        }   
                        else break;   
                    }   
                }   
            }   
            bis.close();   
        return charset;   
    }   

	
}//end class FileProcess
