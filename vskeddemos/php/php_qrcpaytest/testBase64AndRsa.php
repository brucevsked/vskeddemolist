<?php
$navData="{agentnum=101, amount=200, payCode=100304, channelNum=100005, merUrl=http://www.baidu.com, appOrderId=20180614133543123123}";

$navData_base64=base64_encode($navData);

echo $navData_base64;

$rsa = new Crypt_RSA();
$rsa->setHash('md5');

$pubKey='MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJHhkeLnbZr5bBMREWzaz3xzI0wJSKrn/huEtkydXeb5xn4ciRzFLzrqmaq8LyijHOptGh7eEqTBO4TwnfB2M1KDVY6jx/zxHIlA1vK+n85lmxrLhSzVzyN1eXEuxZZ7JdPhRvhteReuh6oiGZkl0wDjREbejSKk8kz2e2mcp1rwIDAQAB';

$rsa->loadKey($pubKey);

$plaintext = $navData_base64;

$rsa->setSignatureMode(CRYPT_RSA_SIGNATURE_PKCS1); 
$signature = $rsa->sign($plaintext);

?>