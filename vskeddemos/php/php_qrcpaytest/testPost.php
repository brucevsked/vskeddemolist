<?php

    $url = "http://47.106.111.38:8001/QRCodeSys/online.action";
$post_data = "reqParam={\"serviceCode\":\"11\"}";

 $ch = curl_init();

 curl_setopt($ch, CURLOPT_URL, $url);
 curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
 // post数据
 curl_setopt($ch, CURLOPT_POST, true);
 // post的变量
 curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
ob_start(); 
 $output = curl_exec($ch);
ob_end_clean();

 //打印获得的数据
  echo ($output);
  
?>