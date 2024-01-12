package com.jat.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.jfinal.core.JFinal;
import com.jfinal.json.FastJson;
import com.jfinal.json.JFinalJson;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.Kv;

import okhttp3.HttpUrl;

/**
 * 微信
 * @author As40098
 *
 */
public class WeChatUtils {
    // 小程序ID
    private static String appid = "wx00000000000000";

    // 小程序密钥
    private static String appSecret = "1680000000000000000000000000000000";

    // 直连商户号
    private static String mchId = "160000000000";

    // 商户平台设置的密钥
    private static String key = "3bonQ85555555555555555555555555555";

    // 证书序列号
    private static String serialNo = "57F90A5D1F62000000000000000000000";

    // 私钥文件地址
    private static String privateKeyFileName = "/assets/1622811294_20220331_cert/apiclient_key.pem";

    /**
     * 获取权限信息
     * @param code
     * @return String {openid=og5I06q7LiV82tu-m9daktwlKKKg, session_key=ox6rjOTkIIAT+Ujkji14ng==}
     */
    public static String getAuthInfo(String code) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", appid);
        data.put("secret", appSecret);
        data.put("grant_type", "authorization_code");
        data.put("js_code", code);
        String result = HttpKit.get("https://api.weixin.qq.com/sns/jscode2session", data);

        return result;
    }

    /**
     * 获取手机号信息
     * @param encryptedData
     * @param iv
     * @param sessionKey
     * @return Kv{"phoneNumber":"13145985931","purePhoneNumber":"13145985931","countryCode":"86","watermark":{"timestamp":1648601482,"appid":"wx5f7c2b02ba91715e"}}
     */
    public static String getPhoneNumber(String encryptedData, String iv, String sessionKey) {
        try {
            byte[] keyByte = Base64.getDecoder().decode(sessionKey);
            byte[] dataByte = Base64.getDecoder().decode(encryptedData);
            byte[] ivByte = Base64.getDecoder().decode(iv);

            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters params = AlgorithmParameters.getInstance("AES");

            params.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, params);

            byte[] result = cipher.doFinal(dataByte);

            return new String (result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取支付签名信息
     * @return
     */
    public static Map<String, Object> getPaySign(String prepayId) {
        String signType = "RSA";
        Long timeStamp = System.currentTimeMillis() / 1000;
        String nonceStr = WeChatUtils.getRandomString(20);
        String packageStr = "prepay_id="+prepayId;

        String paySign;
        try {
            String message = appid + "\n" + timeStamp + "\n" + nonceStr + "\n" + packageStr + "\n";
            paySign = WeChatUtils.sign(message.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appid", appid);
        params.put("timeStamp", timeStamp.toString());
        params.put("nonceStr", nonceStr);
        params.put("package", packageStr);
        params.put("signType", signType);
        params.put("paySign", paySign);

        return params;
    }

    /***
     * 统一下单（生成预付单）
     * @param openid
     * @param orderSn
     * @param price
     * @return
     */
    public static String unifiedOrder(String openid, String orderSn, int price, String notifyUrl) {
        try {
            Kv amount = Kv.by("total", price).set("currency", "CNY");
            Kv payer = Kv.by("openid", openid);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("appid", appid);
            params.put("mchid", mchId);
            params.put("description", "商品描述");// 商品描述
            params.put("out_trade_no", orderSn);// 商户订单号
            params.put("notify_url", notifyUrl);// 通知地址
            params.put("amount", amount);
            params.put("payer", payer);

            String postData = JFinalJson.getJson().toJson(params);
            String payUrl = "https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi";
            Map<String, String> header = WeChatUtils.getAuthorization(payUrl, "POST", postData);

            String jsonString = HttpKit.post(payUrl, postData, header);
            Kv data = FastJson.getJson().parse(jsonString, Kv.class);
            if(data != null) {
                String prepayId = data.getStr("prepay_id");
                if(prepayId != null) {
                    return prepayId;
                }
            }
            System.out.println("支付返回结果："+jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 商户订单号查询
     * @param outTradeNo
     */
    public static String getOrder(String outTradeNo) {
        String url = String.format("https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, mchId);
        Map<String, String> header = WeChatUtils.getAuthorization(url, "GET", "");
        try {
            String result = HttpKit.get(url, null, header);
            System.out.println("查询支付结果："+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检查订单是否已经支付
     * @param outTradeNo
     * @return
     */
    public static boolean checkOrderIsPay(String outTradeNo) {
        // 获取订单信息
        String orderStr = WeChatUtils.getOrder(outTradeNo);

        if(StringUtils.isNotEmpty(orderStr)) {
            Kv data = FastJson.getJson().parse(orderStr, Kv.class);
            if(data != null && data.getStr("trade_state").equals("SUCCESS")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 异步回调加密参数进行解密
     * @param body
     * @return
     */
    public static String decodeNotify(String body) {
        Kv data = FastJson.getJson().parse(body, Kv.class);
        Kv resource = FastJson.getJson().parse(data.getStr("resource"), Kv.class);
        String associatedData = resource.getStr("associated_data");
        String nonceStr = resource.getStr("nonce");
        String cipherText = resource.getStr("ciphertext");

        AesUtil aesUtil = new AesUtil(key.getBytes(StandardCharsets.UTF_8));
        try {
            return aesUtil.decryptToString(associatedData.getBytes(StandardCharsets.UTF_8), nonceStr.getBytes(StandardCharsets.UTF_8), cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取header部分的权限信息
     * @param payUrl
     * @param method
     * @param body
     * @return
     */
    private static Map<String, String> getAuthorization(String payUrl, String method, String body) {
        String nonceStr = WeChatUtils.getRandomString(16);
        long timestamp = System.currentTimeMillis() / 1000;

        HttpUrl httpurl = HttpUrl.parse(payUrl);
        String canonicalUrl = httpurl.encodedPath();
        if (httpurl.encodedQuery() != null) {
            canonicalUrl += "?" + httpurl.encodedQuery();
        }
        String message = method + "\n" + canonicalUrl + "\n" + timestamp + "\n" + nonceStr + "\n" + body + "\n";
        String signature = WeChatUtils.sign(message.getBytes());
        String authorization = "WECHATPAY2-SHA256-RSA2048 mchid=\"" + mchId + "\"," + "nonce_str=\"" + nonceStr + "\"," + "timestamp=\"" + timestamp + "\"," + "serial_no=\"" + serialNo + "\"," + "signature=\"" + signature + "\"";

        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization", authorization);
        header.put("Content-Type", "application/json");

        return header;
    }

    private static String sign(byte[] message) {
        try {
            PrivateKey privateKey = WeChatUtils.getPrivateKey();
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(privateKey);
            sign.update(message);
            return Base64.getEncoder().encodeToString(sign.sign());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取私钥。
     * @return 私钥对象
     */
    private static PrivateKey getPrivateKey() {
        try {
            String privateKeyPath = JFinal.me().getServletContext().getRealPath(privateKeyFileName);
            String content = new String(Files.readAllBytes(Paths.get(privateKeyPath)), "utf-8");
            String privateKey = content.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "").replaceAll("\\s+", "");
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (Exception e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        }
    }

    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    private static String getRandomString(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }
}

