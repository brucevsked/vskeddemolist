package com.jat;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommonsIOTest {
    private static final Logger log = LoggerFactory.getLogger(CommonsIOTest.class);

    private final String encoding="utf-8";

    @Test
    public void readFile() throws IOException {
        String filePath="d:/underthemoon.txt";
        File file1=new File(filePath);
        String fileContent= FileUtils.readFileToString(file1,encoding);
        log.info(fileContent);
    }

    @Test
    public void readFileByLine() throws IOException {
        String filePath="d:/underthemoon.txt";
        File file1=new File(filePath);
        List<String> fileLines= FileUtils.readLines(file1,encoding);
        log.info("{}",fileLines);
        log.info("line count:{}",fileLines.size());
    }

    @Test
    public void writeFile() throws IOException {
        String data1="this is number 123456\r\n";
        String filePath="d:/writeFileTest.txt";
        File file1=new File(filePath);
        //overwrite file content
		FileUtils.writeStringToFile(file1, data1);
        log.info("write finish:{}",data1);
    }

    @Test
    public void writeFileAdd() throws IOException {
        String data1="that is number 987654321\r\n";
        String filePath="d:/writeFileTest.txt";
        File file1=new File(filePath);
        boolean isAppend=true; //append flag
        //overwrite file content
        FileUtils.writeStringToFile(file1, data1,isAppend);
        log.info("write append finish:{}",data1);
    }

    @Test
    public void writeFileAddWithEncode() throws IOException {
        String data1="that is number 987654321999\r\n";
        String filePath="d:/writeFileTest.txt";
        File file1=new File(filePath);
        boolean isAppend=true; //append flag
        //overwrite file content
        FileUtils.writeStringToFile(file1, data1,encoding,isAppend);
        log.info("write append finish:{}",data1);
    }
}
