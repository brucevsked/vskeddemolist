package com.vsked.test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vsked.commom.Page;

public class GenerateTableData {
	String currentPageName="currentPage";
	String pageSizeName="pageSize";
	int recordCount=100;
	
	public void proc1(HttpServletRequest req){
		HttpSession session=req.getSession();
		Map<String, Object> parMap=getMaps(req);
		Page myPage=getPage(parMap);
		myPage.setCount(recordCount);
		List<Map<String, Object>> myDataList=generateTableData(myPage);
		myPage.setDataList(myDataList);
		session.setAttribute("p", myPage);
	}
	
	public List<Map<String, Object>> generateTableData(Page p){
		List<Map<String, Object>> dataList=new LinkedList<Map<String,Object>>();
		for(int i=(p.getCurrentPage()-1)*p.getPageSize()+1;i<=p.getCurrentPage()*p.getPageSize();i++){
			Map<String, Object> myData=new HashMap<String, Object>();
			myData.put("suId", ""+i);
			myData.put("suName", "nameis"+i);
			myData.put("suPass", "passis"+i);
			myData.put("suCredits", "1");
			myData.put("suMobile", "138"+i);
			myData.put("suNick", "nick"+i);
			myData.put("suQq", "qq"+i);
			myData.put("suEmail", "aa"+i+"@vv"+i+".com");
			dataList.add(myData);
		}
		return dataList;
	}
	/**
	 * 获取分页信息
	 * @param request
	 * @return Page
	 */
	public Page getPage(Map<String, Object> m){
		int pageNum=1;
		int pageSize=10;
		if(m.containsKey(currentPageName) && !"".equals(m.get(currentPageName))){
			pageNum=Integer.parseInt((String)m.get(currentPageName));
		}
		if(m.containsKey(pageSizeName) && !"".equals(m.get(pageSizeName))){
			pageSize=Integer.parseInt((String)m.get(pageSizeName));
		}
		Page page=new Page(pageNum,pageSize);
		return page;
	}
	
	/**
	 * 获取参数
	 * @param r
	 * @return
	 */
	public Map<String,Object> getMaps(HttpServletRequest req){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<String> e=req.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, req.getParameter(s));
		}
		return m;
	}
	
}
