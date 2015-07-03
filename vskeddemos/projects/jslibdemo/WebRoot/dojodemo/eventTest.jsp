<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>dojo</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=basePath%>js/dojo193/dojo/dojo.js" data-dojo-config="async: true"></script>
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/dijit/themes/claro/claro.css" media="screen">
<script>
  require([
      "dojo/dom",
      "dojo/on",
      "dojo/parser",
      "dijit/registry",
      "dijit/form/Button",
      "dojo/domReady!"
  ], function(dom, on, parser, registry){
      var myClick = function(evt){
    	  alert(1);
          console.log("I was clicked");
      };
 
      parser.parse();
 
      on(dom.byId("button1"), "click", myClick);
      on(registry.byId("button2"), "click", myClick);
  });
</script>        
  </head>
  
<body class="claro">
  <div>
    <button id="button1" type="button">Button1</button>
    <button id="button2" data-dojo-type="dijit/form/Button" type="button">Button2</button>
    <button id="button3" data-dojo-type="dijit/form/Button" type="button">
      <div>Button4</div>
      <script type="dojo/on" data-dojo-event="click">
        alert(2);
        console.log("I was clicked");
      </script>
    </button>
  </div>
</body>
</html>