package com.vsked.text;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * 转换<UUordernum>62210035114055</UUordernum>为
 * resultMap.put("UUaid",recElement.element("UUaid").getText());
 */
public class XMLToMap {

    private static final Logger log = LoggerFactory.getLogger(XMLToMap.class);

    public static void main(String[] args) {
        try {
            String pathname = "e:/xml1.txt";
            List<String> dataListOld = FileUtils.readLines(new File(pathname), "utf-8");
            String lineResult="";
            String tagName="";
            for (String s : dataListOld) {
                //log.info(s);
//                log.info(s.substring(s.indexOf("<")+1,s.indexOf(">")));
                tagName=s.substring(s.indexOf("<")+1,s.indexOf(">"));
                System.out.println("resultMap.put(\""+tagName+"\",recElement.element(\""+tagName+"\").getText());");
            }
        }catch (Exception e){
            log.error("xml to map error",e);
        }
    }
}
