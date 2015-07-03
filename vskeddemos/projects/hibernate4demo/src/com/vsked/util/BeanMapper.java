package com.vsked.util;

import org.hibernate.cfg.Configuration;

import com.vsked.hibernate.domain.Stock;
import com.vsked.hibernate.domain.UserT;

public class BeanMapper {
	
	public static void initMapper(Configuration c){
		c.addAnnotatedClass(UserT.class);
		c.addAnnotatedClass(Stock.class);
	}

}
