package com.vsked.entity;

import com.jfinal.plugin.activerecord.Model;

public class Student extends Model<Student>{
	public static Student dao=new Student();
	
	public Classes getClasses(){
		return Classes.dao.findById(get("cId"));
	}
}
