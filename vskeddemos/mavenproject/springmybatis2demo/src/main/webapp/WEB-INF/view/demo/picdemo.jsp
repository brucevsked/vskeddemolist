<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>图片示例</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css"	href="${basePath}css/lib/viewer.min.css">
  </head>
  
  <body>
<!-- a block container is required -->
<div>
  <img id="image" src="${basePath }img/demo/bz1.png" alt="Picture">
</div>

<div>
  <ul id="images">
    <li><img src="${basePath }img/demo/bz1.png" alt="Picture 1"></li>
    <li><img src="${basePath }img/demo/bz2.png" alt="Picture 2"></li>
    <li><img src="${basePath }img/demo/bz3.png" alt="Picture 3"></li>
  </ul>
</div>
      <jsp:include page="../include/js.jsp"></jsp:include>
      <script src="${basePath}js/lib/viewer.min.js"></script>
      <script>
      function initViewA1(){
          var $image = $('#image');

          $image.viewer({
            inline: true,
            viewed: function() {
              $image.viewer('zoomTo', 1);
            }
          });

          // Get the Viewer.js instance after initialized
          var viewer = $image.data('viewer');

          // View a list of images
          $('#images').viewer();
      }
      initViewA1();

      </script>
  </body>
</html>