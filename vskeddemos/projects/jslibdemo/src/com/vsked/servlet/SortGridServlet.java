package com.vsked.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsked.data.GenerateData;
import com.vsked.util.BaseJson;
import com.vsked.util.BasicServlet;
import com.vsked.util.GlobalBase;
import com.vsked.util.LogUtil;

public class SortGridServlet extends HttpServlet {
	

	private static final long serialVersionUID = -5849246326879793526L;
	
	BaseJson bj=new BaseJson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processReq(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		processReq(req, resp);
	}
	
	private void processReq(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		BasicServlet.getMapInParameter(req);
		BasicServlet.getMapInAttribute(req);
		
		
		LogUtil.outPutObject(GlobalBase.ajaxCount++);
		
		PrintWriter out = resp.getWriter();
		try {
			System.out.println(req.getParameter("start")+"|"+req.getParameter("limit"));
			int st=req.getParameter("start")!=null?Integer.parseInt(req.getParameter("start")):1;
			int limit=req.getParameter("limit")!=null?Integer.parseInt(req.getParameter("limit")):10;
			int currentPage=req.getParameter("page")!=null?Integer.parseInt(req.getParameter("page")):1;
			boolean isArray=(req.getParameter("isArray")!=null);
			String jsonStr="{"+GenerateData.getTotal(50000000)+","+GenerateData.getPageInfo(currentPage,limit)+","+GenerateData.getHeadData()+","+GenerateData.getJsonBodyData(currentPage,limit,isArray)+"}";
			LogUtil.outPutObject(jsonStr);
			out.write(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.outPutObject("get test data error s3");
		}
		out.close();
				
	}

}
