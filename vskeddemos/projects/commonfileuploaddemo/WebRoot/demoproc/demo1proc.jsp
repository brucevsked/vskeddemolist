<%@page import="com.vsked.util.FilePathUtil"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
  </head>
  
  <body>
   <%
   String uploadPath=request.getRealPath("/").replace("\\", "/")+FilePathUtil.uploadFileSavePath; //文件保存路径
   boolean isMultipart = ServletFileUpload.isMultipartContent(request);//检查输入请求是否为multipart表单数据。
    
    if (isMultipart == true) {
       FileItemFactory factory = new DiskFileItemFactory();//为该请求创建一个DiskFileItemFactory对象，通过它来解析请求。执行解析后，所有的表单项目都保存在一个List中。
       ServletFileUpload upload = new ServletFileUpload(factory);
       List<FileItem> items = upload.parseRequest(request);
       Iterator<FileItem> itr = items.iterator();
       while (itr.hasNext()) {
           FileItem item = (FileItem) itr.next();
           //检查当前项目是普通表单项目还是上传文件。
           if (item.isFormField()) {//如果是普通表单项目，显示表单内容。
               String fieldName = item.getFieldName();
               out.println("<br>"+fieldName+" is:" + item.getString("utf-8"));
           } else {//如果是上传文件，显示文件名。
               String fileName=item.getName();
               out.println("<br>upload file name is:" + new String(fileName.getBytes(),"utf-8"));
               if(fileName!=null){
                   File fullFile=new File(item.getName());
                   File saveFolder=new File(uploadPath);
                   if(!saveFolder.exists())
                       saveFolder.mkdir();
                   
                   File savedFile=new File(uploadPath,fullFile.getName());
                   item.write(savedFile);
               }
           }
       }

    } else {
       out.print("the enctype must be multipart/form-data");
    }
%>
  </body>
</html>
