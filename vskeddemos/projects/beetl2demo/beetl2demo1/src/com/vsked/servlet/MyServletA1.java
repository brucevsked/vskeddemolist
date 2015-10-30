package com.vsked.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsked.test.IncludeTest;

public class MyServletA1 extends HttpServlet {

	private static final long serialVersionUID = 4106192543327366243L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		procReq(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		procReq(req, res);
	}
	
	public void procReq(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(req.getParameter("tp"));
		String tp=req.getParameter("tp");
		if("1".equals(tp)) IncludeTest.procReq(req, res);
		
	}

}
