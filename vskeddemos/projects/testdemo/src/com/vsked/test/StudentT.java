package com.vsked.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;

public class StudentT {
	private int stid;
	private int stname;
	private int stage;
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public int getStname() {
		return stname;
	}
	public void setStname(int stname) {
		this.stname = stname;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		StudentT st1=new StudentT();
		st1.setStid(1);
		st1.setStname(2);
		st1.setStage(3);
		StudentT st2=new StudentT();
		BeanUtils.copyProperties(st2, st1);
		st2.setStage(888);
		st2.setStname(1118);
		st2.setStid(999);
		System.out.println(st1.getStage());
		System.out.println(st2.getStage());
	}

}
