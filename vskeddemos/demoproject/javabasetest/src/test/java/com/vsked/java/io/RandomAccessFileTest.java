package com.vsked.java.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    private static final Logger log = LoggerFactory.getLogger(RandomAccessFileTest.class);

    //换行+唯一标识+英文逗号


    @Test
    public void writeSpecificLine(){
        //要修改第3行数据
        String filePath="d:/userDataTemp.txt";
        try {
            int position=0;//起始位置
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            String s1=file.readLine();
            String s2=file.readLine();
            int startPos=s1.length()+s2.length();
            log.info("当前要修改起始位置{}",startPos);
            byte[] b88591=file.readLine().getBytes("ISO-8859-1");
            int modifyLength=b88591.length+",0,".length()+2;//原始长度+逗号+删除位+2位换行
            log.info("当前要修改长度:{}",modifyLength);
            String oldStr=new String(b88591);
            log.info(oldStr);
//            String newStr=oldStr+",0,"+System.getProperty("line.separator");
            String newStr="8,李k";
            file.setLength(0);
            file.seek(startPos);
            file.write(newStr.getBytes(),startPos,modifyLength);
            file.close();

            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }

    @Test
    public void readFromFile(){
        String filePath="d:/userDataTemp.txt";
        try {
            int position=0;//起始位置
            int size=8;//读取长度
            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            file.seek(position);
            byte[] bytes = new byte[size];
            file.read(bytes);
            file.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }

    @Test
    public void writeNumber(){
        /**
         * 1个数字占1位长度
         */
        String filePath="d:/numberTest.txt";
        try {
            int position=0;//起始位置
            String data="1234567890";
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();

            int size=data.getBytes().length;
            log.info("10个数字长度:{}",size);
            RandomAccessFile fileRead = new RandomAccessFile(filePath, "r");
            fileRead.seek(position);
            byte[] bytes = new byte[size];
            fileRead.read(bytes);
            fileRead.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }

    @Test
    public void writeEnLetter(){
        /**
         * 1个字母占1位长度
         */
        String filePath="d:/enletterTest.txt";
        try {
            int position=0;//起始位置
            String data="abcdefghijklmnopqrstuvwxyz";
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();

            int size=data.getBytes().length;
            log.info("26个字母长度:{}",size);
            RandomAccessFile fileRead = new RandomAccessFile(filePath, "r");
            fileRead.seek(position);
            byte[] bytes = new byte[size];
            fileRead.read(bytes);
            fileRead.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }


    @Test
    public void writeCnLetter(){
        /**
         * 1个中文占3位长度
         */
        String filePath="d:/cnletterTest.txt";
        try {
            int position=0;//起始位置
            String data="一二三四五六";
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();

            int size=data.getBytes().length;
            log.info("6个中文长度:{}",size);
            RandomAccessFile fileRead = new RandomAccessFile(filePath, "r");
            fileRead.seek(position);
            byte[] bytes = new byte[size];
            fileRead.read(bytes);
            fileRead.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }

    @Test
    public void writeNewLine(){
        /**
         * 1个换行占2位长度
         */
        String filePath="d:/newlineTest.txt";
        try {
            int position=0;//起始位置
            String data=System.getProperty("line.separator")+System.getProperty("line.separator")+System.getProperty("line.separator");
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();

            int size=data.getBytes().length;
            log.info("3个换行长度:{}",size);
            RandomAccessFile fileRead = new RandomAccessFile(filePath, "r");
            fileRead.seek(position);
            byte[] bytes = new byte[size];
            fileRead.read(bytes);
            fileRead.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }


    @Test
    public void writeEnSymbol(){
        /**
         * 1个英文符号占1位长度
         */
        String filePath="d:/enSymbolTest.txt";
        try {
            int position=0;//起始位置
            String data=",.+-*/";
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();

            int size=data.getBytes().length;
            log.info("6个英文符号长度:{}",size);
            RandomAccessFile fileRead = new RandomAccessFile(filePath, "r");
            fileRead.seek(position);
            byte[] bytes = new byte[size];
            fileRead.read(bytes);
            fileRead.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }


    @Test
    public void writeCnSymbol(){
        /**
         * 1个中文符号占3位长度
         */
        String filePath="d:/cnSymbolTest.txt";
        try {
            int position=0;//起始位置
            String data="，。（）【】";
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();

            int size=data.getBytes().length;
            log.info("6个中文符号长度:{}",size);
            RandomAccessFile fileRead = new RandomAccessFile(filePath, "r");
            fileRead.seek(position);
            byte[] bytes = new byte[size];
            fileRead.read(bytes);
            fileRead.close();
            String result=new String(bytes);
            log.info(result);
            log.info("-------------");
        } catch (Exception e) {
            log.error("文件访问异常",e);
        }
    }

}
