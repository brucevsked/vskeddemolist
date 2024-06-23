package com.vsked.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2JDBCUtilsTest {

    private static final Logger log = LoggerFactory.getLogger(H2JDBCUtilsTest.class);

    @Test
    public void getConnection() throws SQLException {
        Connection conn = null;
        try{
            conn=H2JDBCUtils.getConnection();
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            conn.close();
        }
    }

    @Test
    public void createTable() throws SQLException {
        Connection conn = null;
        try{
            conn=H2JDBCUtils.getConnection();
            String createTableSQL="";
            createTableSQL+="create table user1(";
            createTableSQL+="id int primary key comment 'this is id',";
            createTableSQL+="name varchar(100) comment '这是名称'";
            createTableSQL+=");";

            Statement statement=conn.createStatement();

            statement.execute(createTableSQL);
            statement.close();
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            conn.close();
        }
    }

    @Test
    public void createTableInsertData() throws SQLException {
        Connection conn = null;
        try{
            conn=H2JDBCUtils.getConnection();
            String createTableSQL="";
            createTableSQL+="create table user1(";
            createTableSQL+="id int primary key comment 'this is id',";
            createTableSQL+="name varchar(100) comment '这是名称'";
            createTableSQL+=");";

            Statement statement=conn.createStatement();

            statement.execute(createTableSQL);
            statement.close();

            String insertSQL="insert into user1(id,name) values(?,?)";
            PreparedStatement prepareStatement=conn.prepareStatement(insertSQL);
            prepareStatement.setInt(1,1);
            prepareStatement.setString(2,"myNameIsVsked");

            log.debug("{}",prepareStatement);

            prepareStatement.executeUpdate();

            prepareStatement.close();

        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            conn.close();
        }
    }

    @Test
    public void createTableInsertDataQuery() throws SQLException {
        Connection conn = null;
        try{
            conn=H2JDBCUtils.getConnection();
            String createTableSQL="";
            createTableSQL+="create table user1(";
            createTableSQL+="id int primary key comment 'this is id',";
            createTableSQL+="name varchar(100) comment '这是名称'";
            createTableSQL+=");";

            Statement statement=conn.createStatement();

            statement.execute(createTableSQL);
            statement.close();

            String insertSQL="insert into user1(id,name) values(?,?)";
            PreparedStatement prepareStatement=conn.prepareStatement(insertSQL);
            prepareStatement.setInt(1,1);
            prepareStatement.setString(2,"myNameIsVsked");

            log.debug("{}",prepareStatement);

            prepareStatement.executeUpdate();

            prepareStatement.setInt(1,2);
            prepareStatement.setString(2,"myNameIsTwo");

            log.debug("{}",prepareStatement);

            prepareStatement.executeUpdate();

            prepareStatement.close();

            String selectSQL="select * from user1";

            PreparedStatement queryPrepareStatement=conn.prepareStatement(selectSQL);
            ResultSet rs=queryPrepareStatement.executeQuery();

            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                log.debug("{},{}",id,name);
            }
            rs.close();
            queryPrepareStatement.close();

        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            conn.close();
        }
    }


}
