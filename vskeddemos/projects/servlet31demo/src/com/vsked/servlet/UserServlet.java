package com.vsked.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UserServlet",value="/UserModule/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3834290498151162010L;


	public void doDelete(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		proc(req,res,  "doDelete");
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet");
		proc(req,res,  "doGet");
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		System.out.println("dopost");
		proc(req,res,  "dopost");
	}

	public void doPut(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doput");
		proc(req,res, "doput");
	}
	
	public void proc(HttpServletRequest req,HttpServletResponse res,String m) throws IOException, ServletException{
		req.setAttribute("reqMethod", m);
		getServletContext().getRequestDispatcher("/userList.jsp").forward(req, res);
	}

}
