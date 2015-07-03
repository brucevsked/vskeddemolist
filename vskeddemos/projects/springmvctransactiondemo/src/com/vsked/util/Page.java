package com.vsked.util;


import java.util.List;

/**
 * 分页信息封装类
 *
 */
public class Page {
	//页号
	private int pagenum;
	//页面显示条数
	private int pagesize;
	//总数据条数
	private int count;
	//总页数
	private int numcount;
	//开始条目
	private int beginnum;
	//结束条目
	private int endnum;
	
	//数据集合
	private List dataList;
	
	public Page(){
		
	}
	/**
	 * 引用此类时使用该构造函数
	 * @param pagenum
	 * @param pagesize
	 */
	public Page(int pagenum,int pagesize){
		this.pagenum=pagenum;
		this.pagesize=pagesize;
		this.setEndnum(pagesize*pagenum);
		this.setBeginnum(this.endnum-pagesize+1);
	}
	
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	
	public int getBeginnum() {
		return beginnum;
	}

	public void setBeginnum(int beginnum) {
		this.beginnum=beginnum<1?1:beginnum;
	}

	public int getEndnum() {
		return endnum;
	}

	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}

	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		this.setNumcount(this.count/pagesize+(this.count%pagesize==0?0:1));
	}
	public int getNumcount() {
		return numcount;
	}
	public void setNumcount(int numcount) {
		this.numcount = numcount;
	}
	
	public String getMysqlPage(){
		return " limit "+(getBeginnum()-1)+","+getPagesize()+" ";
	}
	
}
