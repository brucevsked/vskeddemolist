package com.vsked.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2JDBCUtils {
    private static final String jdbcUrl="jdbc:h2:mem:test";
    private static final String userName="sa";
    private static final String password="";
    private static final String driverName="org.h2.Driver";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,userName,password);
    }

}
