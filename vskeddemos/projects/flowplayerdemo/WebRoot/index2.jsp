<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>flowplayerdemo 1</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
<div>
   <video controls width="624" height="260" id="myVideo1">
<source type="video/mp4" src="${basePath }videolist/test1.mp4">
   </video><br>
   <progress value="0" max="100" id="procBar"></progress>
   <button type="button" id="myBt1" onclick="s2()">play</button>
</div>
<div id="curTime" onclick="ts();"></div>
    <script src="${basePath }js/flowplayer/deps/jquery.min.js"></script>
    <script src="${basePath }js/flowplayer/flowplayer.min.js"></script>
    <script>
    function ts(){
    	console.log(document.getElementById('myVideo1').currentTime)
    	$('#curTime').html(document.getElementById('myVideo1').currentTime);
    }
    ts();
    function s1(){
    	var myVideo1=document.getElementById('myVideo1');
    	console.log(881)
    	myVideo1.controls=false;
    	myVideo1.onended = function() {
    		document.getElementById('myBt1').innerHTML="play";
    	};
    	//console.log(myVideo1.currentTime);//当前时长
    	  $("#myVideo1").on(
    			    "timeupdate", 
    			    function(event){
    			    	console.log('当前时长:'+this.currentTime+'|总时长:'+this.duration);//总时长
    			    	$("#procBar").attr('max',this.duration);
    			    	$("#procBar").attr('value',this.currentTime);
    			    });
    }
    s1();
    function s2(){
    	var myVideo1=document.getElementById('myVideo1');
    	console.log(myVideo1.paused)
    	if(myVideo1.paused){
    		myVideo1.play();
    		document.getElementById('myBt1').innerHTML="pause";
    	}else{
    		myVideo1.pause();
    		document.getElementById('myBt1').innerHTML="play";
    	}
    }
    </script>
  </body>
</html>
