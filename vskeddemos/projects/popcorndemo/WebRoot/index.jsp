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
    
    <title>index</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
  <!-- You need a video element with an id -->
  <video id='video' 
    controls 
    width= '250px'
    poster="test/poster.png"> 
    <source id='mp4'
      src="test/trailer.mp4"
      type='video/mp4; codecs="avc1, mp4a"'> 
    <source id='ogv'
      src="test/trailer.ogv"
      type='video/ogg; codecs="theora, vorbis"'> 
    <p>Your user agent does not support the HTML5 Video element.</p> 
  </video> 
  <!-- this is needed for the footnote plugin -->
  <div id="footnotediv"></div>
  <div id="curTime" onclick="ts();"></div>
   <script src="popcorn.js"></script>
 
  <!-- You must include each plug-in needed for the demo individually. Ensure the path is correct -->
  <!-- Footnote Plugin -->
  <script src="plugins/footnote/popcorn.footnote.js"></script>
  <!-- Subtitle Plugin -->
  <script src="plugins/subtitle/popcorn.subtitle.js"></script>
  <!-- Link popcorn-js to the video by uing the id of the video element -->
  <!-- You need to tell popcorn when you want each plugin to execute -->
  <script>
    // wait for DOM to load
    document.addEventListener('DOMContentLoaded', function () {
      // popcorn events are chainable this means that you can also do:
      // p.play(); or p.footnote{};
      // Make a popcorn instance, passing the id of the video element.
      // notice the <video id='video' ... > at the bottom of the page.
      var p = Popcorn('#video')
      // use the footnote plugin
      // notice the <div id='footnotediv'> tag at the bottom of the page
      .footnote({
        start: 0, // seconds
        end: 15, // seconds
        text: 'This video made exclusively for drumbeat.org',
        target: 'footnotediv'
      } )
      // use the subtitle plugin
      .subtitle({
        start: 1, // seconds
        end: 15, // seconds
        text: 'this is a subtitle'
      } )
      // make the video play automatically 
      .play();
    }, false);
    function ts(){
    	console.log(document.getElementById('video').currentTime)
    	document.getElementById('curTime').innerHTML=document.getElementById('video').currentTime ;
    }
    ts();
  </script>
  </body>
</html>

