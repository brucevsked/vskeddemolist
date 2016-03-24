package com.vsked.service;

public class GridService {
	

	
	//{"page":2,"total":50000,"records":1000000,"rows":[{"ShipName":"GROSELLA-Restaurante","CustomerID":"GROSR","OrderID":"21","OrderDate":"Jul/30/1996","Freight":"66.2900"},{"ShipName":"White Clover Markets","CustomerID":"WHITC","OrderID":"22","OrderDate":"Jul/31/1996","Freight":"4.5600"},{"ShipName":"Wartian Herkku","CustomerID":"WARTH","OrderID":"23","OrderDate":"Aug/1/1996","Freight":"136.5400"},{"ShipName":"Split Rail Beer & Ale","CustomerID":"SPLIR","OrderID":"24","OrderDate":"Aug/1/1996","Freight":"4.5400"},{"ShipName":"Rattlesnake Canyon Grocery","CustomerID":"RATTC","OrderID":"25","OrderDate":"Aug/2/1996","Freight":"98.0300"},{"ShipName":"QUICK-Stop","CustomerID":"QUICK","OrderID":"26","OrderDate":"Aug/5/1996","Freight":"76.0700"},{"ShipName":"Vins et alcools Chevalier","CustomerID":"VINET","OrderID":"27","OrderDate":"Aug/6/1996","Freight":"6.0100"},{"ShipName":"Magazzini Alimentari Riuniti","CustomerID":"MAGAA","OrderID":"28","OrderDate":"Aug/7/1996","Freight":"26.9300"},{"ShipName":"Tortuga Restaurante","CustomerID":"TORTU","OrderID":"29","OrderDate":"Aug/8/1996","Freight":"13.8400"},{"ShipName":"Morgenstern Gesundkost","CustomerID":"MORGK","OrderID":"30","OrderDate":"Aug/9/1996","Freight":"125.7700"},{"ShipName":"Berglunds snabbk?p","CustomerID":"BERGS","OrderID":"31","OrderDate":"Aug/12/1996","Freight":"92.6900"},{"ShipName":"Lehmanns Marktstand","CustomerID":"LEHMS","OrderID":"32","OrderDate":"Aug/13/1996","Freight":"25.8300"},{"ShipName":"Berglunds snabbk?p","CustomerID":"BERGS","OrderID":"33","OrderDate":"Aug/14/1996","Freight":"8.9800"},{"ShipName":"Romero y tomillo","CustomerID":"ROMEY","OrderID":"34","OrderDate":"Aug/14/1996","Freight":"2.9400"},{"ShipName":"Romero y tomillo","CustomerID":"ROMEY","OrderID":"35","OrderDate":"Aug/15/1996","Freight":"12.6900"},{"ShipName":"LILA-Supermercado","CustomerID":"LILAS","OrderID":"36","OrderDate":"Aug/16/1996","Freight":"84.8100"},{"ShipName":"Lehmanns Marktstand","CustomerID":"LEHMS","OrderID":"37","OrderDate":"Aug/19/1996","Freight":"76.5600"},{"ShipName":"QUICK-Stop","CustomerID":"QUICK","OrderID":"38","OrderDate":"Aug/20/1996","Freight":"76.8300"},{"ShipName":"QUICK-Stop","CustomerID":"QUICK","OrderID":"39","OrderDate":"Aug/21/1996","Freight":"229.2400"},{"ShipName":"Ricardo Adocicados","CustomerID":"RICAR","OrderID":"40","OrderDate":"Aug/22/1996","Freight":"12.7600"}],"userdata":{}}
	public String getJqGridData(int page,int rows){
		//TODO modify here
		int total=5000; //总页数
		int records=10000;  //总记录数
		String dt="";
		dt+="{";
		dt+=BasicService.getJsonKey("page")+":"+page+",";
		dt+=BasicService.getJsonKey("total")+":"+total+",";
		dt+=BasicService.getJsonKey("records")+":"+records+",";
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=(page-1)*rows;i<page*rows;i++){
			sb.append("{");
			sb.append(BasicService.getJsonKey("ShipName")+":"+BasicService.getJsonKey("n"+i)+",");
			sb.append(BasicService.getJsonKey("CustomerID")+":"+BasicService.getJsonKey("b"+i)+",");
			sb.append(BasicService.getJsonKey("OrderID")+":"+BasicService.getJsonKey(""+i)+",");
			sb.append(BasicService.getJsonKey("OrderDate")+":"+BasicService.getJsonKey("Jul/30/"+(1990+i))+",");
			sb.append(BasicService.getJsonKey("Freight")+":"+BasicService.getJsonKey("f"+i));
			sb.append("},");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		dt+=BasicService.getJsonKey("rows")+":"+sb.toString()+"";
		dt+="}";
		
		return dt;		
	}
	
}
