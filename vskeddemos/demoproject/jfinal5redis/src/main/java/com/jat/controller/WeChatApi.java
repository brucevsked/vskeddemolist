package com.jat.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.jat.util.WeChatUtils;

import com.jfinal.core.Controller;
import com.jfinal.json.FastJson;
import com.jfinal.kit.Kv;
import org.apache.commons.lang3.StringUtils;


public class WeChatApi extends Controller {
    /**
     * 存储权限键名
     */
    private String authKey = "auth";

    /**
     * 微信授权，获取openid、session_key
     */
    public void setAuth() {
        String code = get("code");
        String authInfo = WeChatUtils.getAuthInfo(code);
        System.out.println("获取微信授权信息："+authInfo);

        setSessionAttr(this.authKey, authInfo);
        String sessionId = getSession().getId();

        Kv data = Kv.by("JSESSIONID", sessionId);
        renderJson(data);
    }

    /**
     * 获取手机号码
     */
    public void getPhoneNumber() {
        String encryptedData = get("encryptedData");
        String iv = get("iv");
        String sessionKey = this.getSessionKey();

        if(sessionKey == null) {
            renderJson(Kv.by("code", 100).set("message", "登录已过期"));
            return;
        }

        String phoneInfo = WeChatUtils.getPhoneNumber(encryptedData, iv, sessionKey);
        System.out.println("获取手机号信息："+phoneInfo);

        renderJson(phoneInfo);
    }

    /**
     * 获取支付参数
     */
    public void getPaymentInfo() {
        int price = 1;
        String orderSn = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String openid = this.getOpenid();
        if(openid == null) {
            renderJson(Kv.by("code", 100).set("message", "登录已过期"));
            return;
        }
        // 定义返回结果地址
        String notifyUrl = getRequest().getRequestURL().toString().split(getRequest().getServletPath())[0]+"/wechat/payNotify";
        // 生成预支付订单
        String prepayId = WeChatUtils.unifiedOrder(openid, orderSn, price, notifyUrl);
        System.out.println("预支付获取prepayId="+prepayId);
        if(prepayId == null) {
            renderJson(Kv.by("message", "生成预付单失败"));
            return;
        }
        Map<String, Object> paymentInfo = WeChatUtils.getPaySign(prepayId);
        if(paymentInfo == null) {
            renderJson(Kv.by("message", "支付失败"));
            return;
        }
        paymentInfo.put("orderSn", orderSn);

        renderJson(paymentInfo);
    }

    /**
     * 支付异步通知
     */
    public void payNotify() {
        String params = getRawData();
        if(StringUtils.isNotEmpty(params)) {
            System.out.println("异步通知参数："+params);
            String result = WeChatUtils.decodeNotify(params);
            if(StringUtils.isNotEmpty(result)) {
                Kv data = FastJson.getJson().parse(result, Kv.class);
                if(data != null) {
                    String state = data.getStr("trade_state");
                    if(state.equals("SUCCESS")) {
                        String orderSn = data.getStr("out_trade_no");
                        if(WeChatUtils.checkOrderIsPay(orderSn)) {
                            // 修改订单信息

                            // 返回正确结果为微信
                            renderJson(Kv.by("code", "SUCCESS").set("message","成功"));
                            return;
                        }
                    }
                }
            }
        }
        renderJson(Kv.by("code", "FAIL").set("message","失败"));
    }

    /**
     * 检查订单是否已经支付成功
     */
    public void checkOrderPayState() {
        String orderSn = get("orderSn");
        if(!WeChatUtils.checkOrderIsPay(orderSn)) {
            renderJson(Kv.by("code", "FAIL").set("message","订单还未支付成功"));
            return;
        }
        renderJson(Kv.by("code", "SUCCESS"));
    }

    /**
     * 获取openid
     * @return
     */
    private String getOpenid() {
        String auth = getSessionAttr(this.authKey);
        Kv data = FastJson.getJson().parse(auth, Kv.class);
        if(data == null) {
            return null;
        }
        return data.getStr("openid");
    }

    /**
     * 获取session_key
     * @return
     */
    private String getSessionKey() {
        String auth = getSessionAttr(this.authKey);
        if(auth == null) {
            return null;
        }
        Kv data = FastJson.getJson().parse(auth, Kv.class);
        if(data == null) {
            return null;
        }
        return data.getStr("session_key");
    }
}

