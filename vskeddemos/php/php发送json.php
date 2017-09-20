<?
$url = "http://113.140.31.190:5930/mobile3/pull/web/cpdata.do?action=encodeData";
$post_data = "hello1234567890";

 $ch = curl_init();

 curl_setopt($ch, CURLOPT_URL, $url);
 curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
 // post数据
 curl_setopt($ch, CURLOPT_POST, true);
  curl_setopt($ch, CURLOPT_HTTPHEADER, array(  
            'Content-Type: application/json; charset=utf-8',  
            'Content-Length: ' . strlen($post_data))  
        ); 
 // post的变量
 curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
ob_start(); 
 $output = curl_exec($ch);
ob_end_clean();

 //打印获得的数据
  echo ($output);
?>