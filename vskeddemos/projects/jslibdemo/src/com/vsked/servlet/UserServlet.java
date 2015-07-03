package com.vsked.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*; 

import com.vsked.data.GenerateData;
import com.vsked.util.BaseJson;

public class UserServlet extends HttpServlet {

	
	private static final long serialVersionUID = -7706893550833347935L;
	
	BaseJson bj=new BaseJson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processReq(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		processReq(req, resp);
	}
	
	private void processReq(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		//resp.setContentType("application/x-javascript;charset=UTF-8");
		//resp.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		try {
			String jsonStr=bj.listToJson(GenerateData.getBodyData());
			System.out.println(jsonStr);
			out.write(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get test data error");
		}
		out.close();
				
	}

}
