<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>gridx</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script>
    dojoConfig= {
    	baseUrl: '<%=basePath%>js/',
    	tlmSiblingOfDojo: false,
        packages: [  
                   { name: "dojo", location: "dojo193/dojo" },  
                   { name: "dijit", location: "dojo193/dijit" },  
                   { name: "dojox", location: "dojo193/dojox" },
                   { name: "xstyle", location: "dojo193/xstyle" },  
                   { name: "put-selector", location: "dojo193/put-selector" },  
                   { name: "dgrid", location: "dojo193/dgrid" },  
                   { name: "gridx", location: "dojo193/gridx" }  
               ],  
        has: {
            'dojo-firebug': true,
            'dojo-amd-factory-scan': true,
            'dojo-firebug': true,
            'dojo-debug-messages': true
        },
        parseOnLoad: true,
        async: true
    };
</script>
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/dojo/resources/dojo.css" media="screen">
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/dijit/themes/claro/claro.css" media="screen">
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/gridx/resources/claro/Gridx.css" media="screen">
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/dojodemo/dojoExtendsConfig.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/dojo193/dojo/dojo.js" data-dojo-config="async: true"></script>
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/dojodemo/gridXDemo.js"></script>
        
  </head>
  
<body class="claro">
	<div id="gridDiv"></div>
</body>
</html>