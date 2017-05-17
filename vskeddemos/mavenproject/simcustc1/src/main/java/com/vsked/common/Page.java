package com.vsked.common;



import java.util.List;
import java.util.Map;

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
	private List<Map<String, Object>> dataList;
	
	String sql="";
	
	public Page(){
		
	}
	/**
	 * 引用此类时使用该构造函数
	 * @param pagenum
	 * @param pagesize
	 */
	public Page(int inCurrentPage,int inPageSize){
		this.setCurrentPage(inCurrentPage);
		this.setPageSize(inPageSize);
		this.setBeginNum(this.endNum-getPageSize()+1);
		this.setEndNum(getPageSize()*this.currentPage);
	}
	
	public List<Map<String, Object>> getDataList() {
		return dataList;
	}
	public void setDataList(List<Map<String, Object>> dataList) {
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
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int inCount) {
		this.count = inCount;
		this.setNumCount(this.count/getPageSize()+(this.count%getPageSize()==0?0:1));
	}
	public int getNumCount() {
		return numCount;
	}
	public void setNumCount(int inNumCount) {
		this.numCount = inNumCount;
	}
	
	public String getMysqlPage(){
		return " limit "+(getBeginNum()-1)+","+getPageSize()+" ";
	}
	
	public String getOraclePage(String inSql){
		sql="";
		sql+="select vskedpn2s.* from (SELECT vskedpn1s.*,ROWNUM vskedpn1sRN FROM (";
		sql+=inSql;
		sql+=") vskedpn1s ) vskedpn2s WHERE vskedpn1sRN between  ";
		sql+=(getEndNum()-getPageSize()+1)+" and "+(getEndNum());
		return sql;
	}
	
	public String getSqlServerPage(String inSql,String orderByColumn){
		sql="";
		sql+="SELECT t.* FROM ( SELECT t1.* , row_number() over(order by "+orderByColumn+" ) r FROM ( ";
		sql+=inSql+" ) t1) t ";
		sql+="where t.r <="+getEndNum()+" and t.r >= "+(getEndNum()-getPageSize()+1);
		return sql;
	}
	
}