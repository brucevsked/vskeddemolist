<?php




function postTest(){
    $url = "http://192.168.3.121:8181/headerTest";

    $signature_base64="aaabbb";
    $reqSign="cccddd";
    
    $post_data = "requestData={\"code\":\"A0001\",\"request\":{\"sign\":\".$signature_base64.\",\"data\":\".$reqSign.\",\"agentNum\":\"230\"}}&unitType=paid";
    
    $ch = curl_init();
    
    $header[0]="Authorization:第二步结果放这里";
    $header[1]="Accept:application/json";
    $header[2]="Content-Type:application/json";
    
    curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
    
    ob_start(); 
    $output = curl_exec($ch);
    ob_end_clean();
    
    echo ("<br>" . $output);
}

//postTest();






class BaseRequestVO {
    public $req_time;
    public $version;
    public $out_org_code;
    public $req_data;
}

class locationInfo{
    public $request_ip;
    public $location;
}

class beiSaoJiaoYi{
    public $merchant_no;
    public $term_no;
    public $auth_code;
    public $out_trade_no;
    public $total_amount;
    public $location_info;
    public $out_order_no;
}

class lakalaopen{


    public static function getReqTime(){
        $res_data = date("YmdHis",time());
        return $res_data;
    }

    /**
     * 
     * @param String $url 请求地址
     * @param array $httpHeader http中header信息
     * @param String $body 要发送的数据体
     * @return $str 响应信息
     */
    function post($url,$authorization,$body){
        
        $headers = [
            "Authorization: " . $authorization,
            "Content-Type:application/json",
            "Accept:application/json"
        ];

		$ch = curl_init();
		curl_setopt($ch, CURLOPT_URL, $url);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
		if (!empty($body)){
			@curl_setopt($ch, CURLOPT_POST, true);
			@curl_setopt($ch, CURLOPT_POSTFIELDS, $body);
		}
		if ( !empty($headers) ){
			curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
		}
		$str = curl_exec($ch);
		curl_close($ch);
		return $str;
    }

    /**
     *
     * 产生随机字符串，不长于30位
     * @param int $length
     * @return $str 产生的随机字符串
     */
    function getNonceStr($length = 32)
    {
        $chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        $str = "";
        for ($i = 0; $i < $length; $i++) {
            $str .= substr($chars, mt_rand(0, strlen($chars) - 1), 1);
        }
        return $str;
    }

    /**
     * 获取毫秒级别的时间戳
     */
    function getMillisecond()
    {
        //获取毫秒的时间戳
        $time = explode(" ", microtime());
		$millisecond = "000".($time[0] * 1000);
		$millisecond2 = explode(".", $millisecond);
		$millisecond = substr($millisecond2[0],-3);
        $time = $time[1] . $millisecond;
        $time=(int)($time/1000);
        return $time;
    }

    function headSign($appId,$mchSerialNo,$timestamp,$nonceStr,$body){
        return "${appId}\n${mchSerialNo}\n${timestamp}\n${nonceStr}\n${body}\n";
    }

    function getAuthorization($appId,$serialNo,$timeStamp,$nonceStr,$body,$privateKeyFilePath){

      	$message = "${appId}\n${serialNo}\n${timeStamp}\n${nonceStr}\n${body}\n";

		$key = openssl_get_privatekey(file_get_contents($privateKeyFilePath));

        openssl_sign($message, $signature, $key, "SHA256");
        openssl_free_key($key);

        return "LKLAPI-SHA256withRSA" . " appid=\"" . $appId . "\"," . "serial_no=\"" . $serialNo . "\"," . "timestamp=\"" . $timeStamp . "\"," . "nonce_str=\"" . $nonceStr . "\"," . "signature=\"" . base64_encode($signature) . "\"";
    }

    function beiSaoJiaoYiReq($appId,$serialNo,$timeStamp,$nonceStr,$body){

    }

}

class lakalaopenTest{

    public function getReqTimeTest(){
        $lakalaopen=new lakalaopen();
        $output = $lakalaopen->getReqTime();
        echo ("<br>" . $output);
    }

    public function getNonceStrTest(){
        $lakalaopen=new lakalaopen();
        $output = $lakalaopen->getNonceStr(32);
        echo ("<br>" . $output);
    }
    
    public function getMillisecondTest(){
        $lakalaopen=new lakalaopen();
        $output = $lakalaopen->getMillisecond();
        echo ("<br>" . $output);
    }

    public function baseRequestVOInfo(){
        $BaseRequestVO=new BaseRequestVO();
        $BaseRequestVO->req_time="20210907150256";
        $BaseRequestVO->version="3.0";
        $BaseRequestVO->out_org_code="OP00000003";
        $BaseRequestVO->req_data="仅测试需要拼装";

        $BaseRequestVOJson=json_encode($BaseRequestVO, JSON_UNESCAPED_UNICODE);
        echo ("<br>" . $BaseRequestVOJson);

    }

    public function beiSaoJiaoYiInfo(){
        $beiSaoJiaoYi=new beiSaoJiaoYi();
        $beiSaoJiaoYi->merchant_no="822290070111135";
        $beiSaoJiaoYi->term_no="29034705";
        $beiSaoJiaoYi->out_trade_no="TEST0E1FAA300070933CDEDAE0000001";
        $beiSaoJiaoYi->total_amount="6";

        $locationInfo=new locationInfo();
        $locationInfo->request_ip="10.176.1.192";
        $locationInfo->location="+37.123456789,-121.123456789";
        $beiSaoJiaoYi->location_info=$locationInfo;
        $beiSaoJiaoYiJson=json_encode($beiSaoJiaoYi, JSON_UNESCAPED_UNICODE);
        echo ("<br>" . $beiSaoJiaoYiJson);
    }

    public function beiSaoJiaoYiRequestBody(){
        $beiSaoJiaoYi=new beiSaoJiaoYi();
        $beiSaoJiaoYi->merchant_no="822290070111135";
        $beiSaoJiaoYi->term_no="29034705";
        $beiSaoJiaoYi->out_trade_no="TEST0E1FAA300070933CDEDAE0000001";
        $beiSaoJiaoYi->total_amount="6";

        $locationInfo=new locationInfo();
        $locationInfo->request_ip="10.176.1.192";
        $locationInfo->location="+37.123456789,-121.123456789";
        $beiSaoJiaoYi->location_info=$locationInfo;
        
        $BaseRequestVO=new BaseRequestVO();
        $BaseRequestVO->req_time="20210907150256";
        $BaseRequestVO->version="3.0";
        $BaseRequestVO->out_org_code="OP00000003";
        $BaseRequestVO->req_data=$beiSaoJiaoYi;

        $BaseRequestVOJson=json_encode($BaseRequestVO, JSON_UNESCAPED_UNICODE);
        echo ("<br>" . $BaseRequestVOJson);        

    }

    public function headSignTest(){
        $lakalaopen=new lakalaopen();

        $appId="OP00000003";
        $serialNo="00dfba8194c41b84cf";
        $timeStamp= $lakalaopen->getMillisecond();
        $nonceStr= $lakalaopen->getNonceStr(32);

        $beiSaoJiaoYi=new beiSaoJiaoYi();
        $beiSaoJiaoYi->merchant_no="822290070111135";
        $beiSaoJiaoYi->term_no="29034705";
        $beiSaoJiaoYi->out_trade_no="TEST0E1FAA300070933CDEDAE0000001";
        $beiSaoJiaoYi->total_amount="6";

        $locationInfo=new locationInfo();
        $locationInfo->request_ip="10.176.1.192";
        $locationInfo->location="+37.123456789,-121.123456789";
        $beiSaoJiaoYi->location_info=$locationInfo;
        
        $BaseRequestVO=new BaseRequestVO();
        $BaseRequestVO->req_time="20210907150256";
        $BaseRequestVO->version="3.0";
        $BaseRequestVO->out_org_code="OP00000003";
        $BaseRequestVO->req_data=$beiSaoJiaoYi;

        $body=json_encode($BaseRequestVO, JSON_UNESCAPED_UNICODE);
    
        $headSignStr= $lakalaopen->headSign($appId,$serialNo,$timeStamp,$nonceStr,$body);
        echo ("<br>" . $headSignStr);
        
    }

    public function headSignTestForJava(){
        $lakalaopen=new lakalaopen();

        $url = "https://test.wsmsd.cn/sit/api/v3/labs/trans/micropay";

        $lakalaopen=new lakalaopen();

        $appId="800000010334001";
        $serialNo="017d6ae9ad6e";
        $timeStamp= $lakalaopen->getMillisecond();
        $nonceStr= $lakalaopen->getNonceStr(32);
        $privateKeyFilePath="d:/api_private_key.pem"; //私钥路径

        $beiSaoJiaoYi=new beiSaoJiaoYi();
        $beiSaoJiaoYi->merchant_no="822290070111135";
        $beiSaoJiaoYi->term_no="29034705";
        $beiSaoJiaoYi->out_trade_no="TEST0E1FAA300070933CDEDAE0000001";
        $beiSaoJiaoYi->auth_code="135178236713755038";
        $beiSaoJiaoYi->total_amount="6";

        $locationInfo=new locationInfo();
        $locationInfo->request_ip="112.232.247.90";
        $locationInfo->location="+37.123456789,-121.123456789";
        $beiSaoJiaoYi->location_info=$locationInfo;

        $beiSaoJiaoYi->out_order_no="08F4542EEC6A4497BC419161747A92FA";
        
        $BaseRequestVO=new BaseRequestVO();
        $BaseRequestVO->req_time=$lakalaopen->getReqTime();
        $BaseRequestVO->version="3.0";
        $BaseRequestVO->out_org_code="OP00000003";
        $BaseRequestVO->req_data=$beiSaoJiaoYi;

        $body=json_encode($BaseRequestVO, JSON_UNESCAPED_UNICODE);


        echo ("<hr>" . $body);

        $headSignStr= $lakalaopen->headSign($appId,$serialNo,$timeStamp,$nonceStr,$body);

        echo ("<hr>" . $headSignStr);

        $f = fopen("d:/testaaaphp.txt", "w");
        $text = $headSignStr;
        fwrite($f, $text);

        $authorization=$lakalaopen->getAuthorization($appId,$serialNo,$timeStamp,$nonceStr,$body,$privateKeyFilePath);

        echo ("<hr>" . $authorization);
                
        $response=$lakalaopen->post($url,$authorization,$body);
        echo("<hr>");
        echo($response);
        
    }

    public function getAuthorizationTest(){
        $lakalaopen=new lakalaopen();

        $appId="OP00000003";
        $serialNo="00dfba8194c41b84cf";
        $timeStamp= $lakalaopen->getMillisecond();
        $nonceStr= $lakalaopen->getNonceStr(32);
        $privateKeyFilePath="d:/api_private_key.pem"; //私钥路径

        $beiSaoJiaoYi=new beiSaoJiaoYi();
        $beiSaoJiaoYi->merchant_no="822290070111135";
        $beiSaoJiaoYi->term_no="29034705";
        $beiSaoJiaoYi->out_trade_no="TEST0E1FAA300070933CDEDAE0000001";
        $beiSaoJiaoYi->total_amount="6";

        $locationInfo=new locationInfo();
        $locationInfo->request_ip="10.176.1.192";
        $locationInfo->location="+37.123456789,-121.123456789";
        $beiSaoJiaoYi->location_info=$locationInfo;
        
        $BaseRequestVO=new BaseRequestVO();
        $BaseRequestVO->req_time="20210907150256";
        $BaseRequestVO->version="3.0";
        $BaseRequestVO->out_org_code="OP00000003";
        $BaseRequestVO->req_data=$beiSaoJiaoYi;

        $body=json_encode($BaseRequestVO, JSON_UNESCAPED_UNICODE);

        $headSignStr= $lakalaopen->headSign($appId,$serialNo,$timeStamp,$nonceStr,$body);

        $authorization=$lakalaopen->getAuthorization($appId,$serialNo,$timeStamp,$nonceStr,$body,$privateKeyFilePath);

        echo ("<br>" . $authorization);

    }

    public function postTest1(){
        $lakalaopen=new lakalaopen();

        $url = "http://192.168.3.121:8181/headerTest";

        $lakalaopen=new lakalaopen();

        $header[0]="Authorization:test111";
        $header[1]="Accept:application/json";
        $header[2]="Content-Type:application/json";
        $body="";

        $response=$lakalaopen->post($url,$header,$body);

        print_r($response);
    }

    public function postTest(){
        $lakalaopen=new lakalaopen();

        $url = "https://test.wsmsd.cn/sit/api/v3/labs/trans/micropay";

        $appId="800000010334001";
        $serialNo="017d6ae9ad6e";
        $timeStamp= $lakalaopen->getMillisecond();
        $nonceStr= $lakalaopen->getNonceStr(32);
        $privateKeyFilePath="d:/api_private_key.pem"; //私钥路径

        $beiSaoJiaoYi=new beiSaoJiaoYi();
        $beiSaoJiaoYi->merchant_no="822290070111135";
        $beiSaoJiaoYi->term_no="29034705";
        $beiSaoJiaoYi->out_trade_no="TEST0E1FAA300070933CDEDAE0000001";
        $beiSaoJiaoYi->auth_code="135178236713755038";
        $beiSaoJiaoYi->total_amount="6";

        $locationInfo=new locationInfo();
        $locationInfo->request_ip="112.232.247.90";
        $locationInfo->location="+37.123456789,-121.123456789";
        $beiSaoJiaoYi->location_info=$locationInfo;

        $beiSaoJiaoYi->out_order_no="08F4542EEC6A4497BC419161747A92FA";
        
        $BaseRequestVO=new BaseRequestVO();
        $BaseRequestVO->req_time=$lakalaopen->getReqTime();
        $BaseRequestVO->version="3.0";
        $BaseRequestVO->out_org_code="OP00000003";
        $BaseRequestVO->req_data=$beiSaoJiaoYi;

        $body=json_encode($BaseRequestVO, JSON_UNESCAPED_UNICODE);


        echo ("<hr>" . $body);

        $headSignStr= $lakalaopen->headSign($appId,$serialNo,$timeStamp,$nonceStr,$body);

        echo ("<hr>" . $headSignStr);

        $authorization=$lakalaopen->getAuthorization($appId,$serialNo,$timeStamp,$nonceStr,$body,$privateKeyFilePath);

        echo ("<hr>" . $authorization);

        $response=$lakalaopen->post($url,$authorization,$body);
        echo("<hr>");
        echo($response);
    }

    public function base64Test(){
        $str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ:=, -+.{}1234567890";
        $result=base64_encode($str);
        echo($result);
    }

    public function rsaTest(){

        $lakalaopen=new lakalaopen();

        $privateKeyFilePath="d:/api_private_key.pem";
        $key = openssl_get_privatekey(file_get_contents($privateKeyFilePath));
        //phpRSA test ok
        //$message="800000010334001\n017d6ae9ad6e\n1665643518\nyqk8Iqvyb4A12VkeYT2IyGBoaVjIgjjk\n{\"req_time\":\"20221013144518\",\"version\":\"3.0\",\"out_org_code\":\"OP00000003\",\"req_data\":{\"merchant_no\":\"822290070111135\",\"term_no\":\"29034705\",\"auth_code\":\"135178236713755038\",\"out_trade_no\":\"TEST0E1FAA300070933CDEDAE0000001\",\"total_amount\":\"6\",\"location_info\":{\"request_ip\":\"112.232.247.90\",\"location\":\"+37.123456789,-121.123456789\"},\"out_order_no\":\"08F4542EEC6A4497BC419161747A92FA\"}}\n";
        
        $appId="800000010334001";
        $mchSerialNo="017d6ae9ad6e";
        $timestamp="1665643518";
        $nonceStr="yqk8Iqvyb4A12VkeYT2IyGBoaVjIgjjk";
        $body="{\"req_time\":\"20221013144518\",\"version\":\"3.0\",\"out_org_code\":\"OP00000003\",\"req_data\":{\"merchant_no\":\"822290070111135\",\"term_no\":\"29034705\",\"auth_code\":\"135178236713755038\",\"out_trade_no\":\"TEST0E1FAA300070933CDEDAE0000001\",\"total_amount\":\"6\",\"location_info\":{\"request_ip\":\"112.232.247.90\",\"location\":\"+37.123456789,-121.123456789\"},\"out_order_no\":\"08F4542EEC6A4497BC419161747A92FA\"}}";

        $message=$lakalaopen->headSign($appId,$mchSerialNo,$timestamp,$nonceStr,$body);
        openssl_sign($message, $signature, $key, "SHA256");
        openssl_free_key($key);
        $result=base64_encode($signature);
        echo($result);
    }


    public function testAll(){
        //$this->getReqTimeTest();
        //$this->getNonceStrTest();
        //$this->getMillisecondTest();
        //$this->baseRequestVOInfo();
        //$this->beiSaoJiaoYiInfo();
        //$this->beiSaoJiaoYiRequestBody();
        //$this->headSignTest();
        $this->headSignTestForJava();
        //$this->getAuthorizationTest();
        //$this->postTest1();
        //$this->postTest();
        //$this->base64Test();
        //$this->rsaTest();
    }

    
}

$lakalaopenTest=new lakalaopenTest();
$lakalaopenTest->testAll();


?>