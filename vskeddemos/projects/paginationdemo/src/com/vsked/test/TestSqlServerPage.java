package com.vsked.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vsked.util.ConnectSqlserver;
import com.vsked.util.Page;

public class TestSqlServerPage {

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectSqlserver.getMySqlConnection();
		String sql="";
		
		String inSql=" select * from [hyfd].[dbo].[testpagea1] ";
		String orderByColumn=" testid asc ";
		Page p=new Page(1,10);
		sql=p.getSqlServerPage(inSql, orderByColumn);
		
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}

}
