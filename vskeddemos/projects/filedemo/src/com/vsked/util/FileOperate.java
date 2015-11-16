package com.vsked.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * FileOperate
 * @author vsked
 *
 */
public class FileOperate {
	private static String[] af=null;
	public static String imageExt="bmp,BMP,JPG,jpg,JPEG,jpeg,gif,GIF,";
	public static String voiceExt="wav,WAV,MP3,mp3,amr,AMR,";
	
	/**
	 * read file
	 * @param fname
	 * @return
	 */
	public static String readFile(String fname) throws Exception {
		String content = "";
		FileReader fr = new FileReader(new File(fname));
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			String s = br.readLine();
			if("".equals(content)) content=s;
		    else content += s + "#";
		}
		br.close();
		fr.close();
		return content;
	}
	
    /**
     * readFile by Encoding
     * @param fname 
     * @param enCoding 
     * @return
     */
	public static String readFile(String fname,String enCoding) throws Exception {
		String content = "";
		BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname)),enCoding.trim())));
		while (br.ready()) {
		    String s = br.readLine();
			if("".equals(content)) content=s;
			else content += s + "#";
			
		}
		br.close();
		return content;
	}//end method
	
	public static String[] readAllFilesinDirectory(String strv) {
		File f = new File(strv);
		if(f.list()!=null){
		String fs[] = f.list();	
		af=new String[fs.length];
		for (int i = 0; i < fs.length; i++) {				
		    File fv = new File(fs[i]);
			if (fv.canWrite()) break;
			else af[i]=fs[i];
		}
		}
		return af;
	}
	
	

    /**   
     * delete file or Directory
     * @param   fileName      
     * @return delete success return true else false
     */   
    public static boolean delete(String fileName){    
        File file = new File(fileName);    
        if(!file.exists()) return false;    
        else{    
            if(file.isFile()) return deleteFile(fileName);    
            else return deleteDirectory(fileName);    
        }    
    }    
        
    /**   
     * delete a file  
     * @param   fileName    
     * @return delete success return true else false
     */   
    public static boolean deleteFile(String fileName){    
        File file = new File(fileName);    
        if(file.isFile() && file.exists()){    
            file.delete();    
            return true;    
        }else return false;    
    }    
        
    /**   
     * delete file or file in Directory or Folder
     * @param   dir file or Directory  
     * @return  delete success return true,else false   
     */   
    public static boolean deleteDirectory(String dir){    
        if(!dir.endsWith(File.separator)) dir = dir+File.separator;
        
        File dirFile = new File(dir);    
        if(!dirFile.exists() || !dirFile.isDirectory()) return false;
        
        boolean flag = true;    
        //delete all file or directory in folder
        File[] files = dirFile.listFiles();    
        for(int i=0;i<files.length;i++){    
            //delete subFile
            if(files[i].isFile()){    
                flag = deleteFile(files[i].getAbsolutePath());    
                if(!flag) break;    
            }    
            //delete subDirectory
            else{    
                flag = deleteDirectory(files[i].getAbsolutePath());    
                if(!flag) break;    
            }    
        }    
            
        if(!flag) return false;    
        //delete current directory
        if(dirFile.delete()) return true;    
        else return false;    
    }    
    
	public static String getDBConfig(String fname) throws Exception{		
		return FileOperate.readFile(fname);
		
	}
	
	/** 
     * copy file
     * @param oldPath String source
     * @param newPath String now file 
     * @return boolean 
     */ 
   public static void copyFile(String oldPath, String newPath) throws Exception { 
	   int bytesum = 0; 
       int byteread = 0; 
       File oldfile = new File(oldPath); 
       if (oldfile.exists()) { //exists file
           InputStream inStream = new FileInputStream(oldPath); //read sourcefile
           FileOutputStream fs = new FileOutputStream(newPath); 
           byte[] buffer = new byte[1444]; 
           while ( (byteread = inStream.read(buffer)) != -1) { 
               bytesum += byteread;
               fs.write(buffer, 0, byteread); 
           } 
           inStream.close(); 
       } 
   }//end copy file	
   
   /** 
    * new folder
    * @param folderPath String like c:/fqf 
    * @return boolean 
    */ 
  public static void newFolder(String folderPath) { 
	  String filePath = folderPath; 
      filePath = filePath.toString(); 
      File myFilePath = new File(filePath); 
      if (!myFilePath.exists())  
          myFilePath.mkdir(); 
  }//end newFolder 

  /** 
    * new file
    * @param filePathAndName String filePath
    * @param fileContent String file Content
    * @return boolean 
    */ 
  public static void newFile(String filePathAndName, String fileContent) throws Exception { 
	  String filePath = filePathAndName; 
      filePath = filePath.toString(); 
      File myFilePath = new File(filePath); 
      if (!myFilePath.exists())
          myFilePath.createNewFile(); 
      FileWriter resultFile = new FileWriter(myFilePath); 
      PrintWriter myFile = new PrintWriter(resultFile); 
      String strContent = fileContent; 
      myFile.println(strContent); 
      resultFile.close(); 

  }//end newFile 
  
  /**
   * new file
   * @param filePathAndName file save path
   * @param fileContent 
   * @param encoding 
   */
  public static void newFile(String filePathAndName, String fileContent,String encoding) throws Exception {
	  String filePath = filePathAndName; 
      filePath = filePath.toString(); 
      File myFilePath = new File(filePath); 
      if (!myFilePath.exists())
          myFilePath.createNewFile(); 
      Writer resultFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myFilePath), encoding));
      PrintWriter myFile = new PrintWriter(resultFile); 
      String strContent = fileContent; 
      myFile.println(strContent); 
      resultFile.close(); 
  }//end newFile
  
 /**
  * file encoding
  * @param oldPath 
  * @param newPath 
  * @param oldEncoding 
  * @param newEncoding 
  */
  public static void changeEncoding(String oldPath, String newPath,String oldEncoding,String newEncoding) throws Exception {
      File file = new File(oldPath); // get old file
	  FileReader fr = new FileReader(file);
	  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),oldEncoding));
	  File file2 = new File(newPath);// change encoding path
	  file2.createNewFile();
	  FileWriter fw = new FileWriter(file2);
	  BufferedWriter bw = new BufferedWriter(fw);
	  String str;
	  while ((str = br.readLine()) != null) {
	      bw.write(new String(str.getBytes(), newEncoding));
	  }
	  br.close();
	  fr.close();
	  bw.close();
	  fw.close();

  }//end changeEncoding
	
  /**
	 * 
	 * @param inFilePath
	 * @param outFilePath
	 * @param inWidth
	 * @param inHeight
	 */
	public static void changePictureSize(String inFilePath,String outFilePath,int inWidth,int inHeight) throws Exception{
		File src = new File(inFilePath) ;
        Image image = ImageIO.read(src) ;
        int width = inWidth ;
        int height = inHeight ;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
        bufferedImage.getGraphics().drawImage(image, 0, 0, width, height,null) ;
        FileOutputStream fos = new FileOutputStream(outFilePath) ;
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos) ;
        encoder.encode(bufferedImage) ;
        fos.close();
		
	}
	
	public static void saveFile(String str) throws Exception
	{
		JFileChooser jfch = new JFileChooser();
		int x = jfch.showSaveDialog(null);
		if(x==0)
		{
			String fpath = jfch.getSelectedFile().getAbsolutePath();			
			File f = new File(fpath);
			FileWriter fw = new FileWriter(f,true);
			fw.write(str);
			fw.close();				
		}//end if
	}//end save file
	
	 public void rename(String inOldName,String inNewName){   
		 File f=new File(inOldName);
		 f.renameTo(new File(inNewName));
	 }
	public static String getConfigFilePath(){
		return FileOperate.class.getProtectionDomain().getCodeSource().getLocation().toString().replace("file:/", "").substring(0, FileOperate.class.getProtectionDomain().getCodeSource().getLocation().toString().replace("file:/", "").lastIndexOf("/")+1).replace("%20", " ");
	}
	public String getConfigFilePathForEvery(){
		return this.getClass().getProtectionDomain().getCodeSource().getLocation().toString().replace("file:/", "").substring(0, this.getClass().getProtectionDomain().getCodeSource().getLocation().toString().replace("file:/", "").lastIndexOf("/")+1).replace("%20", " ");
	}
	
	public static List getAllDisk() throws Exception{
		List diskList=new ArrayList();
		for(File f:new File(".").listRoots())
			diskList.add(f.getCanonicalPath().replace("\\", "/"));
		return diskList;
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

}
