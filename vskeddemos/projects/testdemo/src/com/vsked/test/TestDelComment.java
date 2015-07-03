package com.vsked.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * use delete the decompile code comment
 * @author vsked 201302180856
 *
 */
public class TestDelComment {

	public static void main(String[] args) throws Exception {
		String codePath="E:/fff/";
		getFileList(new File(codePath));
		
	}
	
	public static void deleteFileComment(String fname) throws Exception{
		String fpath=fname;
		File f=new File(fpath);
		String s=readFileByLine(f);
		String charSet=getCharset(f);
		writeFile(fpath, s, charSet);
	}
	
	public static String readFileByLine( File inF) throws Exception{
		FileInputStream fis=new FileInputStream(inF.getCanonicalPath());
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));  
		String data = "";  
		String tmp="";
		while((data = br.readLine())!=null)  
		{  
		    tmp+=data.replace(getComment(data,false), "")+"\n";
		} 
		tmp=tmp.replace(getComment(tmp,true), "");
		fis.close();
		return tmp;
	}
	
	public static void writeFile(String saveFilePath,String fileContent,String charSet) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024); 
		FileChannel fc=new FileOutputStream(saveFilePath).getChannel();
		Charset cs = Charset.forName(charSet);  
		for(int i=0;i<fileContent.length();i++){
			buffer.put(new String(fileContent.charAt(i)+"").getBytes());
			buffer.flip();
			fc.write(buffer);
			buffer.clear(); 
		}
		
	}
	
	public static String getComment(String s,boolean isEnd){
		String exp="/\\*(.)*\\*/";
		if(isEnd)
			exp="/\\*\\s(.)*\\s*(.)*\\s*(.)*\\s*(.)*";
		Matcher m = Pattern.compile(exp).matcher(s);
		if(m.find())
			return m.group();
		return "";
	}
	
	public static void getFileList(File f) throws Exception{
		if(f.isDirectory()&&!f.getName().equals(".svn")){
			if(f.listFiles()!=null)
			for(File c:f.listFiles())
				getFileList(c);
		}else{
			if(f.getName().endsWith(".java")){
			System.out.println("now process:"+f.getAbsolutePath().replace("\\", "/"));
			deleteFileComment(f.getAbsolutePath().replace("\\", "/"));
			}
		}
	}
	
	public static String getCharset(File file) throws Exception {   
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
