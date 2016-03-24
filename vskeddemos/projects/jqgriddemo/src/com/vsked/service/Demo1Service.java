package com.vsked.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1Service extends BasicService{
	
	public void getData(HttpServletRequest req,HttpServletResponse resp){
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=utf-8");
		Map<String, Object> m=getMaps(req);
//		System.out.println(m);
		int page=Integer.parseInt((String)m.get("page"));
		int rows=Integer.parseInt((String)m.get("rows"));
		try {
			PrintWriter pw=resp.getWriter();
			String dt=new GridService().getJqGridData(page,  rows);
			pw.write(dt);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

}
