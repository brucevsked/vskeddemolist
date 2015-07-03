package com.vsked.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*; 

import com.vsked.data.GenerateData;
import com.vsked.util.BaseJson;

public class GenerateServlet extends HttpServlet {

	private static final long serialVersionUID = 4574559381678197718L;
	
	BaseJson bj=new BaseJson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processReq(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		processReq(req, resp);
	}
	
	private void processReq(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		try {
			String jsonStr="{"+GenerateData.getHeadData()+","+GenerateData.getJsonBodyData()+"}";
			out.write(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get test data error s2");
		}
		out.close();
				
	}

}
