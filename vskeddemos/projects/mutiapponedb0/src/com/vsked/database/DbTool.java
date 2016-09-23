package com.vsked.database;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DbTool {

	static Logger log = Logger.getLogger(DbTool.class);

	public static String confile = "jdbc.properties";

	static DataSource ds = null;

	static boolean isInit = false;

	/**
	 * 获取数据源
	 * 
	 * @return {DataSource} 返回一个可用数据源
	 * @throws Exception
	 */
	public static synchronized DataSource getDataSource() throws Exception {
		if (!isInit) {
			Properties p = new Properties();
			InputStream inputStream = null;
			try {
				// java应用
				confile = DbTool.class.getClassLoader().getResource("")
						.getPath()
						+ "../" + confile;
				log.debug(confile);
				File file = new File(confile);
				inputStream = new BufferedInputStream(new FileInputStream(file));
				p.load(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
			} finally {
				try {
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e.getMessage());
				}
			}
			ds = DruidDataSourceFactory.createDataSource(p);
			isInit = true;
			return ds;
		} else {
			return ds;
		}

	}

	/**
	 * 根据用户名获取用户余额
	 * @param username 要查询余额的用户名
	 * @return {String} 没有用户时将会返回0.000有用户时将会返回这个用户的余额
	 */
	public static synchronized String getUserBalanceByUserName(String username) {
		String userBalance = "0.000";
		try {
			String getUserBalanceSql="select balance from usertest where username=? ";
			DataSource ds = DbTool.getDataSource();
			Connection conn = ds.getConnection();
			PreparedStatement ps=conn.prepareStatement(getUserBalanceSql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userBalance=rs.getString("balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return userBalance;
	}
	
	public static synchronized boolean userRecharge(String username,BigDecimal money){
		BigDecimal userBalance=new BigDecimal(0);
		
		boolean isSuccess=false;
		DataSource ds = null;
		Connection conn = null;
		String ids="";
		try {
			ds = DbTool.getDataSource();
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String getUserBalanceSql="select ids,balance from usertest where username=? ";
			PreparedStatement ps=conn.prepareStatement(getUserBalanceSql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//根据用户名取出当前用户余额
				userBalance=rs.getBigDecimal("balance");
				ids=rs.getString("ids");
			}
			//充扣值后余额
			BigDecimal result=userBalance.add(money);
			
			if(result.compareTo(new BigDecimal(0))<0){
				log.debug("用户余额不足|"+username+"|当前余额|"+userBalance+"|将要充扣|"+money+"|充扣后结果|"+result+"|");
				System.out.println("用户余额不足|"+username+"|当前余额|"+userBalance+"|将要充扣|"+money+"|充扣后结果|"+result+"|");
				conn.setAutoCommit(true);
				//余额不足
				return false;
			}
		    
			//余额充足
			String updateUserBalanceSql="update usertest set balance=? where username=? ";
			PreparedStatement upBalancePs=conn.prepareStatement(updateUserBalanceSql);
			upBalancePs.setDouble(1, result.doubleValue());
			upBalancePs.setString(2, username);
			//晚新用户余额为充扣后结果
			int resultCount=upBalancePs.executeUpdate();
			
			if(resultCount!=1){
				conn.setAutoCommit(true);
				//更新用户余额失败
				return false;
			}
			
			String insertUserTestRecharegeHis="insert into usertestrechargehis";
			insertUserTestRecharegeHis+="(ids,userids,username,oldbalance,money,newbalance,type) ";
			insertUserTestRecharegeHis+="values(?,?,?,?,?,?,?) ";
			
			PreparedStatement userTestRechargeHisPs=conn.prepareStatement(insertUserTestRecharegeHis);
			String tmpUUID=getUUID();
			userTestRechargeHisPs.setString(1, tmpUUID);
			userTestRechargeHisPs.setString(2, ids);
			userTestRechargeHisPs.setString(3, username);
			userTestRechargeHisPs.setDouble(4, userBalance.doubleValue());
			userTestRechargeHisPs.setDouble(5, money.doubleValue());
			userTestRechargeHisPs.setDouble(6, result.doubleValue());
			userTestRechargeHisPs.setString(7, "1");
			
			log.debug(ids+"|"+tmpUUID+"|"+username+"|"+userBalance+"|"+money+"|"+result);
			
			userTestRechargeHisPs.execute();
			
			//更新用户余额信息
			//挺入消费记录表
			
			
			conn.setAutoCommit(true);
			isSuccess=true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			try {
				if (conn != null) {
					conn.rollback();
					conn.setAutoCommit(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error(e1.getMessage());
			}

		}
		
		return isSuccess;		
	}
	
	/**
	 * 获取32位uuid
	 * @return
	 */
	public static synchronized String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
