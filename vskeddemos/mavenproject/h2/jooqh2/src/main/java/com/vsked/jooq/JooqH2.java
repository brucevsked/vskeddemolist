package com.vsked.jooq;

import org.jooq.DSLContext;
import org.jooq.InsertQuery;
import org.jooq.conf.RenderNameCase;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;


public class JooqH2 {

    private static final Logger log = LoggerFactory.getLogger(JooqH2.class);

    private static final String jdbcUrl="jdbc:h2:mem:test";
    private static final String userName="sa";
    private static final String password="";
    private static final String driverName="org.h2.Driver";


    public static void createTable(){
        DSLContext context= DSL.using(jdbcUrl,userName,password);
        context.createTable("user1")
                .column("id", SQLDataType.INTEGER)
                .column("name", SQLDataType.VARCHAR)
                .execute();
    }

    public static void createTableInsertData(){
        DSLContext context= DSL.using(jdbcUrl,userName,password);
        context.createTable("USER1")
                .column("ID", SQLDataType.INTEGER)
                .column("NAME", SQLDataType.VARCHAR)
                .execute();
        InsertQuery insertQuery=context.insertQuery(DSL.table("USER1"));
        insertQuery.addValue(DSL.field("ID",Integer.class),1);
        insertQuery.addValue(DSL.field("NAME"),"myNameIsVsked");
        insertQuery.execute();
    }

    public static void createTableInsertDataQuery(){
        DSLContext context= DSL.using(jdbcUrl,userName,password);
        context.createTable("USER1")
                .column("ID", SQLDataType.INTEGER)
                .column("NAME", SQLDataType.VARCHAR)
                .execute();
        InsertQuery insertQuery=context.insertQuery(DSL.table("USER1"));
        insertQuery.addValue(DSL.field("ID",Integer.class),1);
        insertQuery.addValue(DSL.field("NAME"),"myNameIsVsked");
        insertQuery.execute();

        insertQuery=context.insertQuery(DSL.table("USER1"));
        insertQuery.addValue(DSL.field("ID",Integer.class),2);
        insertQuery.addValue(DSL.field("NAME"),"myNameIsTwo");
        insertQuery.execute();

        List<Map<String, Object>> datas=context.selectFrom("USER1").fetchMaps();
        log.debug("{}",datas);


    }

}
