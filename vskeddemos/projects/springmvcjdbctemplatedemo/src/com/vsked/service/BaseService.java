package com.vsked.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.BaseDao;



@Service
@Transactional
public class BaseService {
	@Autowired
	private BaseDao bd;

	public void add(Map m){ bd.add(m); }
	public void edit(Map m){ bd.edit(m); }
	public void del(Map m){ bd.del(m); }
	public List findAll(Map m){ return bd.findAll(m); }
}
