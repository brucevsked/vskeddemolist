package com.hs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hs.bean.BaseUserT;
import com.hs.dao.BaseUserTDao;
import com.hs.service.BaseUserTService;
import com.hs.util.BaseLog;

@Service
@Transactional
public class BaseUserTServiceImpl implements BaseUserTService{
	
	@Autowired
	private BaseUserTDao d;

	@Override
	public BaseUserT queryById(int buId) {
		return d.queryById(buId);
	}

	@Override
	public BaseUserT queryByName(String buLoginName) {
		return d.queryByName(buLoginName);
	}

	@Override
	public void add(BaseUserT u) {
		d.add(u);
	}

	@Override
	public void update(BaseUserT u) {
		d.update(u);
	}

	@Override
	public void login(Map<String, String> u) {
		
	}

	@Override
	public void delete(Integer buId) {
		d.delete(buId);
	}
	
	@Override
	public List<BaseUserT> queryAll() {
		try {
			int x=Integer.parseInt("f0");
			int y=0/0;
		} catch (Exception e) {
			BaseLog.getLog(this.getClass(), e);
		}
		return d.queryAll();
	}
	
	

}
