<?php
require_once './phpseclib1.0.11/Math/BigInteger.php';
require_once './phpseclib1.0.11/Crypt/RSA.php';


$PUBLICKKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQyamojHDMZHwghP/UV1Qu8MfHYPfMoBe+9kJOUMhh/oWUewEtLnv/hVIia2alTZWaUOu4fSQ0rQ9l35d7qw8pNEH9fLFocENt1OD8TxvwtG3URnWpWMBNB8XAx16+rBAbj+BsA6lQnGtEj0BD+jqLA9RJoJqt/BmK5lToXjXjiQIDAQAB";
$pubKey=$PUBLICKKEY;
$PUBLICKKEY ="-----BEGIN PUBLIC KEY-----\n" . $PUBLICKKEY . "\n-----END PUBLIC KEY-----\n" ;
$PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJDJqaiMcMxkfCCE/9RXVC7wx8dg98ygF772Qk5QyGH+hZR7AS0ue/+FUiJrZqVNlZpQ67h9JDStD2Xfl3urDyk0Qf18sWhwQ23U4PxPG/C0bdRGdalYwE0HxcDHXr6sEBuP4GwDqVCca0SPQEP6OosD1Emgmq38GYrmVOheNeOJAgMBAAECgYBc4jJH4Yi/ZrtGtWvVkgx8bJUNMAToLc/t/tc8nJBgZULWpS51CLwdiS7Oy+22oBYYQE9oNEfUzyzwosbwXCXFxysbBtnXlqLuMnbSjW7DFn8fpIkgu9OYI9ecEOABZ8PkrWohAVswjaim3rwa7cDNaT8YDFzb3KLcfM24x885gQJBAMKceEX6u2WTX2BSITeAW3QCcS2BzRgoHNvDLp4rV0UCHDJkygSJXk/fh+kmT+LDkiJ7kh7soIFpp2uiIjHFe7ECQQC+dcZ51u09xXRJEGx0FeuMrUgNXEqODopUQofIRo1YM6fCwzTcQ5kgX/2DPGOLr+vw2iezJDVaZhVAutBrC9NZAkEAsWo384QLByT9FDCLe6+WsAHx78yfjuAyvt4HR8a3PoAX+JEN4mjhA+wCWTjGJzKnrKv+oBaUlKYfLO6YQcuJYQJAEgtUd3yeU2jeoIF21PSysUxFdEaXJahJALyg4p+UipOyRCh8XJXm7wNJIGLbR4OuRc5VToqSp3Ledph8YHfpWQJAcfoU/lzoRG9XdX5v49dFULuFU5Wozq70bJDCxtXB6MKsL89vfJ17bx4Vq8eyDzQygh2qKkDF4aWzKGtvSIVp2g==";

//----------------------------验证签名1ok start
 //{sign=El8yLAqi8r7iNoD65OHGuMGp9fezdRzU9miKiCF/gPWPleNwBSd+2EVFxsxOPaQ5QjyuvylMTlCkj+ZHO2LBLUBeYx4iOaK3KVDGKWkGjM5plvhCCrs83dWN1nm4Fmb7MNZy1/m6eFn9hSo/g8i8VzeBQdDBcUPzHLu72FwmsWI=, respCode=0000, url=https://cashier.sandpay.com.cn/fastPay/quickPay/index?charset=UTF-8&signType=0&data={"body":{"body":"电器","frontUrl":"http://www.baidu.com","currencyCode":"156","orderCode":"180621092454978","extend":"","subject":"电器批发","userId":"2If65nxeY5","totalAmount":"000000005000","orderTime":"20180621092454","notifyUrl":"http://47.106.111.38:8001/QRCodeSys/ShandeQuickBackUrl.action","clearCycle":"0"},"head":{"channelType":"07","reqTime":"20180621092454","plMid":"","method":"sandPay.fastPay.quickPay.index","mid":"11957405","accessType":"1","productId":"00000016","version":"1.0"}}&sign=dwy8qserk6TTJNioqf9tDbACVeKbFxmI%2FT%2FdijXmirkRnmA77JYKlNY0euESBLUPvaQttLKhGPiAweCnPHgF4N5TSq5XFgmn7lp2NVwlJQ43j%2BU%2BOIlqwix%2BNQ6ZRYKpgNOMRUMGjqKGsVS7IEDdTJWJDNk6oAv3uNhkZH6rmmapilMvudglltTpOCCjGWe1jYI6Jqqhk3FOF0fOBLYCN5vedJ5rEwyfAfaAXTeJGEt1FIVACqtBw6S77RkXL2mmOAz9J6JGUDeU59yPj1RdwX0CHML4HjQtLOCr83O14%2FSLaox%2BpOsn5yS3OnxLVrlVj%2BQc%2FRNJVrYttlJBFysHzw%3D%3D&extend=, respInfo=一键快捷链接获取成功}

 $respSign="El8yLAqi8r7iNoD65OHGuMGp9fezdRzU9miKiCF/gPWPleNwBSd+2EVFxsxOPaQ5QjyuvylMTlCkj+ZHO2LBLUBeYx4iOaK3KVDGKWkGjM5plvhCCrs83dWN1nm4Fmb7MNZy1/m6eFn9hSo/g8i8VzeBQdDBcUPzHLu72FwmsWI=";
 $respSign_base64Decode=base64_decode($respSign);
 $respMap="{respCode=0000, url=https://cashier.sandpay.com.cn/fastPay/quickPay/index?charset=UTF-8&signType=0&data={\"body\":{\"body\":\"电器\",\"frontUrl\":\"http://www.baidu.com\",\"currencyCode\":\"156\",\"orderCode\":\"180621092454978\",\"extend\":\"\",\"subject\":\"电器批发\",\"userId\":\"2If65nxeY5\",\"totalAmount\":\"000000005000\",\"orderTime\":\"20180621092454\",\"notifyUrl\":\"http://47.106.111.38:8001/QRCodeSys/ShandeQuickBackUrl.action\",\"clearCycle\":\"0\"},\"head\":{\"channelType\":\"07\",\"reqTime\":\"20180621092454\",\"plMid\":\"\",\"method\":\"sandPay.fastPay.quickPay.index\",\"mid\":\"11957405\",\"accessType\":\"1\",\"productId\":\"00000016\",\"version\":\"1.0\"}}&sign=dwy8qserk6TTJNioqf9tDbACVeKbFxmI%2FT%2FdijXmirkRnmA77JYKlNY0euESBLUPvaQttLKhGPiAweCnPHgF4N5TSq5XFgmn7lp2NVwlJQ43j%2BU%2BOIlqwix%2BNQ6ZRYKpgNOMRUMGjqKGsVS7IEDdTJWJDNk6oAv3uNhkZH6rmmapilMvudglltTpOCCjGWe1jYI6Jqqhk3FOF0fOBLYCN5vedJ5rEwyfAfaAXTeJGEt1FIVACqtBw6S77RkXL2mmOAz9J6JGUDeU59yPj1RdwX0CHML4HjQtLOCr83O14%2FSLaox%2BpOsn5yS3OnxLVrlVj%2BQc%2FRNJVrYttlJBFysHzw%3D%3D&extend=, respInfo=一键快捷链接获取成功}";
 $respMap_base64=base64_encode($respMap);
 $rsa = new Crypt_RSA();
 $rsa->setHash('md5');
 $rsa->setSignatureMode(CRYPT_RSA_SIGNATURE_PKCS1);
 $rsa->loadKey($pubKey);
 $vfy=$rsa->verify($respMap_base64,$respSign_base64Decode) ? 'verified' : 'unverified';
 
echo "|" .$vfy . "|<br>";

//-------------------------验证签名1ok end

?>