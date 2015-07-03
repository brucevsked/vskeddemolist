package com.vsked.util;



import java.util.List;

/**
 * 分页信息封装类
 *
 */
public class Page {
	//页号
	private int currentPage;
	//页面显示条数
	private int pageSize;
	//总数据条数
	private int count;
	//总页数
	private int numCount;
	//开始条目
	private int beginNum;
	//结束条目
	private int endNum;
	
	//数据集合
	private List dataList;
	
	public Page(){
		
	}
	/**
	 * 引用此类时使用该构造函数
	 * @param pagenum
	 * @param pagesize
	 */
	public Page(int inCurrentPage,int inPageSize){
		this.currentPage=inCurrentPage;
		this.pageSize=inPageSize;
		this.setBeginNum(this.endNum-getPagesize()+1);
		this.setEndNum(getPagesize()*this.currentPage);
	}
	
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	
	public int getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(int inBeginNum) {
		this.beginNum=inBeginNum<1?1:inBeginNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int inEndNum) {
		this.endNum = inEndNum;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}
	public void setCurrentPage(int inCurrentPage) {
		this.currentPage = inCurrentPage;
	}
	public int getPagesize() {
		return this.pageSize;
	}
	public void setPagesize(int inPageSize) {
		this.pageSize = inPageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int inCount) {
		this.count = inCount;
		this.setNumCount(this.count/getPagesize()+(this.count%getPagesize()==0?0:1));
	}
	public int getNumCount() {
		return numCount;
	}
	public void setNumCount(int inNumCount) {
		this.numCount = inNumCount;
	}
	
	public String getMysqlPage(){
		return " limit "+(getBeginNum()-1)+","+getPagesize()+" ";
	}
	
	public String getOraclePage(String inSql){
		return "select * from ("+inSql+")  tmpPageT where RN between "+(getEndNum()-getPagesize()+1)+" and "+(getEndNum());
	}
	
}
