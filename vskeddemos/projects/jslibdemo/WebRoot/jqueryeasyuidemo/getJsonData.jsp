<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String s="";
System.out.println(request.getParameter("vt"));
if(request.getParameter("vt")!=null && "1".equals(request.getParameter("vt"))){
s+="[{\"display\":\"a\",\"name\" :\"a0\",\"width\":90,\"sortable\" :true,\"align\" :\"center\"},";
s+="{\"display\":\"a1\",\"name\" :\"a1\",\"width\":90,\"sortable\" :true,\"align\" :\"center\"},";
s+="{\"display\":\"a55\",\"name\" :\"a1\",\"width\":90,\"sortable\" :true,\"align\" :\"center\"},";
s+="{\"display\":\"a2\",\"name\" :\"a2\",\"width\":90,\"sortable\" :true,\"align\" :\"center\"}]";
}
if(request.getParameter("vt")!=null && "2".equals(request.getParameter("vt"))){
	s+="{\"page\":2,\"rows\":[";
	s+="{\"cell\":[\"11\",\"2\",\"3\",\"4\",\"a\",\"5\"],\"flexrowid\":\"\"},";
	s+="{\"cell\":[\"12\",\"2\",\"3\",\"4\",\"b\",\"5\"],\"flexrowid\":\"\"},";
	s+="{\"cell\":[\"13\",\"2\",\"3\",\"4\",\"c\",\"5\"],\"flexrowid\":\"\"}],";
	s+="\"total\":21}";
}
out.write(s);
%>

