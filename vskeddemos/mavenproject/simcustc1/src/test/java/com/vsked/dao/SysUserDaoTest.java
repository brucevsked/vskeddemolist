package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;


public class SysUserDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysUserDaoTest.class);
	
	@Autowired
	SysUserDao sysUserDao;
	
//	@Test
	public void getSysUserBySuName(){
		String suName="testusera1";
		Map<String, Object> userMap= sysUserDao.getSysUserBySuName(suName);
		log.debug(userMap);
	}
	
//	@Test
	public void getSysUserBySuId(){
		String suId="774F9DD2073143CDAC95EF45A17390E2";
		Map<String, Object> userMap= sysUserDao.getSysUserBySuId(suId);
		log.debug(userMap);
	}
	
//	@Test
	public void getSysUserCount(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("suName", "testusera1");
		int userCount=sysUserDao.getSysUserCount(m);
		log.debug(userCount);
	}
	
//	@Test
	public void getSysUserList(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("suName", "testusera1");
		List<Map<String, Object>> userList=sysUserDao.getSysUserList(m);
		log.debug(userList);
		log.debug(userList.size());
	}
	
//	@Test
	public void sysUserAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("suName", "testusera1");
		m.put("suNick", "nickName");
		m.put("suPass", "670b14728ad9902aecba32e22fa4f6bd");
		m.put("suMobile", "13869170459");
		int effectLine=sysUserDao.sysUserAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysUserEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("suId", "54008A632D45470AAFC74D740C94DC52");
		m.put("suName", "中文名字登录");
		m.put("suNick", "这是别名");
		m.put("suMobile", "1705566788");
		int effectLine=sysUserDao.sysUserEdit(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysUserPassChange(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("suId", "774F9DD2073143CDAC95EF45A17390E2");
		m.put("suPass", "670b14728ad9902aecba32e22fa4f6bd");
		int effectLine=sysUserDao.sysUserPassChange(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysUserDel(){
		String suId="774F9DD2073143CDAC95EF45A17390E2";
		int effectLine=sysUserDao.sysUserDel(suId);
		log.debug(effectLine);
	}
	
	
}
