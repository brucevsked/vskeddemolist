package com.vsked.java.lang;

import com.vsked.test.jdk.BookRecord;
import com.vsked.test.jdk.MenuRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class RecordTest {

    private static final Logger log = LoggerFactory.getLogger(RecordTest.class);

    @Test
    public void menuRecordTest(){
        MenuRecord menuRecord=new MenuRecord(1L,"mainMenu");
        log.info("{}",menuRecord.id());
        log.info(menuRecord.name());

    }

    @Test
    public void userRecordTest(){
        BookRecord book = new BookRecord.Builder()
                .setId(1L)
                .setName("Java编程思想")
                .setType("技术书籍")
                .setAuthor("Bruce Eckel")
                .build();
        
        log.info("{}",book);

    }


}
