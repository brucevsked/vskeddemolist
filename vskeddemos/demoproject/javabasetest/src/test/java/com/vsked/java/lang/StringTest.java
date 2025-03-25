package com.vsked.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class StringTest {

    private static final Logger log = LoggerFactory.getLogger(StringTest.class);

    @Test
    public void format(){
        String s1="117.22042401049421";
        Double d1=Double.parseDouble(s1);
        String result=String.format("%.4f",d1);//保留小数点后4位
        log.debug("{}",result);
    }

    @Test
    public void stringToInt(){
        String s="1.883484";
        int v1=Double.valueOf(s).intValue();
        log.debug("int value:{}",v1);
    }

    @Test
    public void trimTest(){
        String a1="   abce";
        log.info("空格在前|{}|",a1.trim());
        String b1="def   ";
        log.info("空格在后|{}|",b1.trim());
        String c1="d   e  f";
        log.info("空格在中|{}|",c1.trim());
        String d1="    he   ll    o   wor   l   d      ";
        log.info("空格在前中后|{}|",d1.trim());

        String e1="    h   e   l   l    o   w  o  r   l   d      ";
        String e1Trim=e1.replace(" ","");
        log.info("方案1只去空格，不能去空白字符，制表符，换页符等|{}|",e1Trim);

        String f1="    h   e   l   l    o   w  o  r   l   d      ";
        String f1Trim=f1.replaceAll("\\s*","");
        log.info("方案2去空格,去空白字符，制表符，换页符等|{}|",f1Trim);
    }

    @Test
    public void inputStreamToString(){
        String fileName="d:/application.ttf";
        try {
            InputStream is=new FileInputStream(new File(fileName));
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] bytes=new byte[1024];
            int len;
            while((len=is.read(bytes))!=-1){
                baos.write(bytes,0,len);
            }
            is.close();
            String result=baos.toString();
            baos.close();
            log.debug("{}",result);
        } catch (Exception e) {
            log.error("file error please check",e);
        }

    }


    @Test
    public void dataToArray(){
        String s="0,1,2,3,4,5,6,7,8,9";
        String[] tmpArray=s.split(",");
        tmpArray[3]="A";
        tmpArray[4]="B";

        String r=String.join(",",tmpArray);
        log.debug("{}",r);
    }

}
