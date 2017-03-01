package com.vsked.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.vsked.dao.SysFunctionDao;


@Service
@Transactional
public class SysFunctionSer extends BaseService {
	
	public Logger log = Logger.getLogger(this.getClass());

	@Autowired
	SysFunctionDao sysFunctionDao;
	

	public int getSysFunctionCount(Map<String, Object> m) {
		int count = 0;
		try {
			count = sysFunctionDao.getSysFunctionCount(m);
		} catch (Exception e) {
			getMyLog(e,log);
		}
		return count;
	}

	public List<Map<String, Object>> getSysFunctionList() {
		return sysFunctionDao.getSysFunctionList();
	}

	public String getSysFunction() {
		Session session = getSession();
		List<Map<String, Object>> sysFunctionList = sysFunctionDao.getSysFunctionList();
		session.setAttribute("sysFunction", sysFunctionList);
		return "system/sysFunctionAdd";
	}
	

	public String sysFunctionEditPage(String sfId) {
		try {
			Map<String, Object> sysFunction = sysFunctionDao
					.getSysFunctionBySfId(sfId);
			Session session = getSession();
			session.setAttribute("sysFunction", sysFunction);
		} catch (Exception e) {
			getMyLog(e,log);
		}
		return "system/sysFunctionEdit";
	}

}
