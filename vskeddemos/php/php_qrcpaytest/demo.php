<?php
require_once './phpseclib1.0.11/Math/BigInteger.php';
require_once './phpseclib1.0.11/Crypt/RSA.php';

$oldData="{agentnum:\"101\",inPhone:\"\",payCode:\"100701\",outPhone:\"\",channelNum:\"100001\",outCard:\"\",settlementName:\"\",realFee:\"100\",inCard:\"\",amount:\"5000\",crpIdNo:\"\",inBankName:\"中国招商银行\",outCardExpire:\"\",outCardCvv2:\"\",appOrderId:\"10120180615140044\"}" ;

echo $oldData . "<br>";

$oldData_base64 = base64_encode($oldData);

echo $oldData_base64 . "<br>";

$oldData_decode = base64_decode($oldData_base64) ;
echo "|" .$oldData_decode . "|<br>";

$rsa = new Crypt_RSA();
$rsa->setHash('md5');

$PUBLICKKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQyamojHDMZHwghP/UV1Qu8MfHYPfMoBe+9kJOUMhh/oWUewEtLnv/hVIia2alTZWaUOu4fSQ0rQ9l35d7qw8pNEH9fLFocENt1OD8TxvwtG3URnWpWMBNB8XAx16+rBAbj+BsA6lQnGtEj0BD+jqLA9RJoJqt/BmK5lToXjXjiQIDAQAB";
$PUBLICKKEY ="-----BEGIN PUBLIC KEY-----\n" . $PUBLICKKEY . "\n-----END PUBLIC KEY-----\n" ;
$PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJDJqaiMcMxkfCCE/9RXVC7wx8dg98ygF772Qk5QyGH+hZR7AS0ue/+FUiJrZqVNlZpQ67h9JDStD2Xfl3urDyk0Qf18sWhwQ23U4PxPG/C0bdRGdalYwE0HxcDHXr6sEBuP4GwDqVCca0SPQEP6OosD1Emgmq38GYrmVOheNeOJAgMBAAECgYBc4jJH4Yi/ZrtGtWvVkgx8bJUNMAToLc/t/tc8nJBgZULWpS51CLwdiS7Oy+22oBYYQE9oNEfUzyzwosbwXCXFxysbBtnXlqLuMnbSjW7DFn8fpIkgu9OYI9ecEOABZ8PkrWohAVswjaim3rwa7cDNaT8YDFzb3KLcfM24x885gQJBAMKceEX6u2WTX2BSITeAW3QCcS2BzRgoHNvDLp4rV0UCHDJkygSJXk/fh+kmT+LDkiJ7kh7soIFpp2uiIjHFe7ECQQC+dcZ51u09xXRJEGx0FeuMrUgNXEqODopUQofIRo1YM6fCwzTcQ5kgX/2DPGOLr+vw2iezJDVaZhVAutBrC9NZAkEAsWo384QLByT9FDCLe6+WsAHx78yfjuAyvt4HR8a3PoAX+JEN4mjhA+wCWTjGJzKnrKv+oBaUlKYfLO6YQcuJYQJAEgtUd3yeU2jeoIF21PSysUxFdEaXJahJALyg4p+UipOyRCh8XJXm7wNJIGLbR4OuRc5VToqSp3Ledph8YHfpWQJAcfoU/lzoRG9XdX5v49dFULuFU5Wozq70bJDCxtXB6MKsL89vfJ17bx4Vq8eyDzQygh2qKkDF4aWzKGtvSIVp2g==";

$rsa->loadKey($PRIVATEKEY);
$plaintext = $oldData_base64;

$rsa->setSignatureMode(CRYPT_RSA_SIGNATURE_PKCS1); 
$signature = $rsa->sign($plaintext);

$signature_base64=base64_encode($signature) ;

echo "|" .$signature_base64 . "|<br>";
//-----------------------------------------------here is ok
$reqSign="";
 $crypto = '';
        foreach (str_split($plaintext, 117) as $chunk) {
        	 $encryptData="";
            openssl_public_encrypt($chunk, $encryptData, $PUBLICKKEY);
            $crypto .= $encryptData;
        }
        $encrypted = base64_encode($crypto);

$reqSign=$encrypted;
echo "|" .$reqSign . "|<br>";

$url = "http://47.106.111.38:8001/QRCodeSys/online.action";
$post_data = "reqParam={\"serviceCode\":\"A0220\",\"request\":{\"sign\":\".$signature_base64.\",\"data\":\".$reqSign.\",\"account\":\"13518614465\"}}";
$post_data=str_replace(".","",$post_data);
$post_data=str_replace("+","%2b",$post_data);
echo $post_data;
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