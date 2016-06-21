<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.getSession().setAttribute("ACEGI_SAVED_REQUEST_KEY",null);
String ip=request.getRemoteAddr();

  
String type = request.getParameter("type");
String message = "";
if (type == null) {
 message = "";
} else if (type.equals("1")) {
	message = "帐号或密码错误！";
} else if (type.equals("2")) {
	message = "";
} else if (type.equals("3")) {
	message = "与服务器的连接已断开，请重新登录";
} else if (type.equals("4")) {
	message = "校验码不正确，登录失败！";
}else if (type.equals("6")) {
	message = "该用户已登录,同一帐号不能同时多次登录!";
}else if (type.equals("7")) {
	message = "您不是本系统的正式用户！";
} else if (type.equals("5")) {
	message = "对不起，您当前的帐号暂时没有访问本系统的权限!";
}
%>
<!DOCTYPE HTML >

<html> 
<head> 
<title>Login</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<%@ page isELIgnored="false" %> 
<style type="text/css">  
body{height:100%;padding:0; margin:0; font-family:微软雅黑,Arail; font-size:12px;}  
body,html{height:100%;}
body,input{font-family:微软雅黑,Arail; font-size:12px;}
#outer{height:100%; overflow:hidden; position:relative; width:100%; background:#EEE;}  
#outer[id]{display:table; position:static;}  
#middle {position: absolute; top:50%;left:0;}  
#middle[id] {display:table-cell; vertical-align:middle; position:static;}  
#inner {position:relative; top:-50%; margin:0 auto;}  
#content{width:500px; height:300px; border:1px solid; background:#EEE; margin:0 auto;}
#top {height:100px; width:100%; border-bottom-width:1px; border-bottom-style:solid; border-bottom-color:#EAE;}
#bottom {margin-top:10px;}
#msg{height:16px; width:100%; margin-bottom:10px;}
.input_border{height:17px; width:150px; }
A img{border: none;}
</style>

</head> 

<body onload="document.getElementById('userName').focus();">  
<div id="outer">  
    <div id="middle">  
        <div id="inner">  
             <div id="content">
				<div id="top"><img src="images/login-logo.jpg" width="100%" height="100px"></img></div>
				<div id="bottom" align="center">
					<div id="msg"><font color="red">${message}</font></div>
					<form id=loginform method=post name=loginform action="login.html?main">
						用户名：<input type=text id=userName name=usercode class="input_border" maxlength=16/> <p/>
						密<span style="visibility:hidden">码</span>码：<input type=password id=password name=password class="input_border"/></p><%--
						验证码：<input type=text id=j_checkcode name=j_checkcode maxlength=4 style="width:85px;height:17px;"/>&nbsp;<a href="" onClick="document.getElementById('CheckPic').src='<%=request.getContextPath()%>/verifycode?a='+Math.random()"><img  id="CheckPic" src="<%=request.getContextPath()%>/verifycode" style="vertical-align:middle"/></a><br/>--%><br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="submit" type="submit"  value="登录" /> &nbsp;&nbsp;
						&nbsp;&nbsp;<input type="reset" name="reset" value="重置" onclick="document.getElementById('j_username').focus();"/>
					</form>
				</div>
			 </div>  
        </div>  
    </div>  
</div>  
</body>  
</html>
