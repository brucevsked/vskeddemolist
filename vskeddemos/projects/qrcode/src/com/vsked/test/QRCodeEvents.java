package com.vsked.test;
import java.io.File;
import java.util.Hashtable;

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

public class QRCodeEvents {
	public static void main(String []args)throws Exception{  
        String text = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=this%20is%20a%20test%20message%20ok%20good%20&oq=swetake&rsv_pq=da8725580000a4fc&rsv_t=e622dyHcDrWkdllV3aBXnWrOv192XRW%2BeGiYOC9hJLg8diPDbCSz4niV%2Fes&rsv_enter=0&inputT=6125&rsv_sug3=34&rsv_sug1=19&rsv_sug2=0&rsv_sug4=10155";
        System.out.println(text.length());
        int width = 500;  
        int height = 500;  
        String format = "png";  
        Hashtable hints= new Hashtable();  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
         BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);  
         File outputFile = new File("d:/new.png");  
         MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);  
           
    }  
}
