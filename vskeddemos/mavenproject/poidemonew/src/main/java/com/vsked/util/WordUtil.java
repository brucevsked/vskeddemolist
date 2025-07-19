package com.vsked.util;

import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class WordUtil {

    public static void main(String[] args) throws Exception {

        File docxFile=new File("d:/1-1-1.docx");

        if(docxFile.length()<=0){
            System.out.println("当前文件长度为0");
//            return ""; //解决空文件异常问题
        }

        InputStream is = Files.newInputStream(docxFile.toPath());
        XWPFDocument doc = new XWPFDocument(is);

        XHTMLOptions options=XHTMLOptions.create();
        options.setFragment(true);

        String tmpSavePath=docxFile.getParentFile().getAbsolutePath();
        String tmpSaveFileName=docxFile.getName().replace("docx","html");

//        System.out.println("当前文件路径："+docxFile.getParentFile().getAbsolutePath());

        File htmlFile=new File(tmpSavePath+tmpSaveFileName);

        OutputStream outputStream= Files.newOutputStream(htmlFile.toPath());
        XHTMLConverter.getInstance().convert(doc,outputStream,options);
        System.out.println("----------------");
        try {
            is.close();
        } catch (Exception e) {
            System.out.println("关闭文件流异常"+e.getMessage());
        }

    }
}
