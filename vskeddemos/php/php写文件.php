<?
 $myDir="testfolder1";
 if(!file_exists($myDir))
 mkdir($myDir,0777);
 $file="vskedlog20180915.txt";
 $content="this is log1\r\n";
 file_put_contents($myDir."/".$file, $content,FILE_APPEND);
 $content="this is log2\r\n";
 file_put_contents($myDir."/".$file, $content,FILE_APPEND);
 $content="this is log3\r\n";
 file_put_contents($myDir."/".$file, $content,FILE_APPEND);
?>