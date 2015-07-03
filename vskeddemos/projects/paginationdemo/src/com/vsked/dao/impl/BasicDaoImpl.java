package com.vsked.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.vsked.dao.BasicDao;
import com.vsked.util.ConnectOracle;
import com.vsked.util.Page;

public class BasicDaoImpl implements BasicDao{
	
	Connection conn=null;
	
	public void setConn(Connection inConn){
		this.conn=inConn;
	}

	@Override
	public int getCount(String inTbName,Map<String, String> m) {
		int c=0;
		try{
	    String sql="select count(1) vskCount from "+inTbName+getWhereSql(m);
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){ c=rs.getInt(1); }
		ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public String getWhereSql(Map<String, String> m) {
		if(m==null) return "";
		m.remove("currentPage");
		StringBuilder sb=new StringBuilder(" where 1=1 ");
		Iterator<Map.Entry<String, String>> it = m.entrySet().iterator();
		while(it.hasNext()){
			sb.append(" "+it.next().getValue()+" ");
		}
		return sb.toString();
	}

	@Override
	public Page getList(String inTbName,Page p, Map<String, String> m) {
		List dataList=new LinkedList();
		p.setCount(getCount(inTbName, m));
		String sql = "select rownum RN , "+inTbName+".* from "+inTbName+getWhereSql(m)+" order by testids ";
		sql=p.getOraclePage(sql);
		try{
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			Map dm=new HashMap();
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				dm.put(rs.getMetaData().getColumnName(i), rs.getString(i));
			}
			dataList.add(dm);
		}
		p.setDataList(dataList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void main(String[] args) throws Exception {
		String inTbName="testTableInfo";
		BasicDaoImpl bd=new BasicDaoImpl();
		bd.setConn(ConnectOracle.getConnection());
		Map<String, String> m=new HashMap<String, String>();
		/*
		m.put("userName", "and userName like '%1%'");
		m.put("userPass", "and userPass='111'");
		m.put("userState", "and userState=1");
		System.out.println(bd.getWhereSql(m));
		*/
		System.out.println(bd.getCount(inTbName, m));
	}

}
