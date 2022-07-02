package com.vsked.util;

import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class WordUtil {

    public static void main(String[] args) throws Exception {

        File docxFile=new File("d:/1-1-1.docx");

        if(docxFile.length()<=0){
            System.out.println("当前文件长度为0");
//            return ""; //解决空文件异常问题
        }

        InputStream is = new FileInputStream(docxFile);
        XWPFDocument doc = new XWPFDocument(is);

        XHTMLOptions options=XHTMLOptions.create();
        options.setFragment(true);

        String tmpSavePath=docxFile.getParentFile().getAbsolutePath();
        String tmpSaveFileName=docxFile.getName().replace("docx","html");

//        System.out.println("当前文件路径："+docxFile.getParentFile().getAbsolutePath());

        File htmlFile=new File(tmpSavePath+tmpSaveFileName);

        OutputStream outputStream=new FileOutputStream(htmlFile);
        XHTMLConverter.getInstance().convert(doc,outputStream,options);
        System.out.println("----------------");
        if (is != null) {
            try { is.close();
            } catch (Exception e) { e.printStackTrace(); }
        }

    }
}
