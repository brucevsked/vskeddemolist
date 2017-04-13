package com.vsked.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class TmpAgentDao {
	
	Logger  log = Logger.getLogger(TmpAgentDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 清空tmpAgent表中所有数据
	 */
	public void cleanAll(){
		//truncate table tmpAgent 如果换成这个会立即提交 并不在springmvc事务控制范围内
		//delete from tmpAgent 事务可以控制
		String sql="delete from tmpAgent";
		log.debug(sql);
		jdbcTemplate.update(sql);
	}
	
	/**
	 * 添加数据到表tmpAgent表中
	 * @param agentSet
	 */
	public void batchAdd(Set<String> agentSet){
		Integer effectLine=0;
		String sql="insert into tmpAgent(agentName) values(?) ";
		final List<String> dataList=new ArrayList<String>(agentSet);
		BatchPreparedStatementSetter bpss=new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				String data=dataList.get(index);
				ps.setString(1, data);
			}
			
			public int getBatchSize() {
				return dataList.size();
			}
		};
		
		int[] resultArray=jdbcTemplate.batchUpdate(sql, bpss);
		for(int i:resultArray){
			effectLine+=i;
		}
		log.debug(effectLine);
	}
	
	public List<Map<String, Object>> getAll(){
		String sql="select * from tmpAgent ";
		return jdbcTemplate.queryForList(sql);
	}
}
