package com.vsked.jooq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class JooqH2Test {

    private static final Logger log = LoggerFactory.getLogger(JooqH2Test.class);

    @Test
    public void createTable(){
        JooqH2.createTable();
    }

    @Test
    public void createTableInsertData() {
        JooqH2.createTableInsertData();

    }

    @Test
    public void createTableInsertDataQuery(){
        JooqH2.createTableInsertDataQuery();
    }



}
