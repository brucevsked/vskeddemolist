package com.vsked.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.vsked.util.BasicAction;

@ParentPackage("json-default")
@Namespace("/testJsonModule")
public class TestJsonAction extends BasicAction{
	
	private static final long serialVersionUID = 6070571325618443096L;
	
	private Object jsonDataVs1 = "";

	public Object getJsonDataVs1() {
		return jsonDataVs1;
	}

	public void setJsonDataVs1(Object jsonDataVs1) {
		this.jsonDataVs1 = jsonDataVs1;
	}


	@Action(value = "/getJsonData", results = { @Result(name = "getJ", type = "json") }, params = {"root","jsonDataVs1"})  
	public Object getJsonData(){
		String jsonValue="{\"tableHead\":";
		jsonValue+="[";
		jsonValue+="[{\"tbName\":\"userT\",\"columns\":[[\"ids\",\"number\",6],[\"uname\",\"varchar2\",5],[\"userpass\",\"a\",11]]}],";
		jsonValue+="[{\"tbName\":\"user1T\",\"columns\":[[\"ids\",\"number\",7],[\"uname\",\"varchar2\",10],[\"userpass\",\"b\",12]]}],";
		jsonValue+="[{\"tbName\":\"user2T\",\"columns\":[[\"ids\",\"number\",8],[\"uname\",\"varchar2\",50],[\"userpass\",\"c\",13]]}]";
		jsonValue+="]}";

        setJsonDataVs1(jsonValue);
		
		System.out.println(getJsonDataVs1());
		return "getJ";
	}

}
