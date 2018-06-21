<?php

  $myStr="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`1234567890-=";
  $myRs=base64_encode($myStr);
  echo $myRs ;
  echo '<br>';

  $kkkRs=base64_decode($myRs);
  
  echo $kkkRs ;
?>