package com.vsked.entity;


import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User>{

	private static final long serialVersionUID = -6855906046849980072L;
	
	public static final User dao=new User();
	
	public Page<User> list(int pageNum,int pageSize){
		return paginate(pageNum, pageSize, "select * ", "from userT order by uId desc");
	}
	
}
