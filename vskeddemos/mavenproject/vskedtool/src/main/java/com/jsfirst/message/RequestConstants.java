package com.jsfirst.message;

/**
 * 业务接收请求码
 * 
 * @author liy
 * 
 */
public class RequestConstants {
	public static final String REQ_MSG = "online";
	public static final String REQ_MERC_PERFECT = "B0100";// 完善商户，并去通道方注册商户、下载密钥、签约卡
	public static final String REQ_SCANCODE_SALE = "A0200";// 扫码消费
	public static final String REQ_ERWEIMA_SALE = "B0200";// 反扫消费
	public static final String REQ_QUICKPAY_SALE = "A0210";// 快捷支付
	public static final String REQ_QUICKPAY_FRONT = "K0200";// 快捷支付
	public static final String REQ_QUICKPAY_CONFIRM = "B0210";// 快捷支付确认
	public static final String REQ_PRIKEY_DOWNLOADE = "A0600";// 下载密钥

	public static final String REQ_CARD_SIGNED = "C1212"; // 卡签约
	public static final String REQ_MERC_QUERY = "A1000"; // 通道商户状态查询

	public static final String REQ_CARD_IN_CHANNEL = "Q1001"; // 通道商户状态查询
	public static final String REQ_CHANNEL_CARD_STATUS = "Q1002"; // 通道卡状态
	public static final String REQ_QUERY_SCAN_ORDER = "Q0200"; // 查询二维码支付状态
	public static final String REQ_QUERY_QUICK_ORDER = "Q0210"; // 查询快捷支付状态

	public static final String LDYS_H5_SALE = "A0360";// 联动优势H5收银台获取url
	public static final String LDYS_WEB_SALE = "A0340";// 联动优势WEB收银台获取url
	public static final String LDYS_EBANKDIRECT_SALE = "A0350";// 联动优势网银直连获取url
	public static final String REQ_QUERT_CASHIER_ORDER = "Q0220";// 查询收银台支付状态
	public static final String LDYS_ORDER_CALLBACK = "C0210";// 联动优势交易回调

	public static final String RONGBAO_H5_SALE = "A0410";// 融宝H5获取url
	public static final String RONGBAO_WEB_SALE = "A0420";// 融宝web获取url
	public static final String RONGBAO_ORDER_CALLBACK = "C0410";// 融宝交易回调
	public static final String REQ_WEB_QUICK_ORDER = "Q0230";// 融宝查询网银

	public static final String SHANDE_QUICK_SALE = "A0330";// 杉德一键快捷获取url
	
	/**
	 * 极易付绑卡N0110
	 * 参见业务接收请求码规范.txt
	 */
	public static final String JiYiFu_BingCard="N0110";
	
	/**
	 * 极易付发短信N0120
	 * 参见业务接收请求码规范.txt
	 */
	public static final String JiYiFu_SendSms="N0120";
	
	/**
	 * 极易付交易N0130
	 * 参见业务接收请求码规范.txt
	 */
	public static final String JiYiFu_Trade="N0130";
	
	/**
	 * 极易付交易结果查询N0140
	 * 参见业务接收请求码规范.txt
	 */
	public static final String JiYiFu_PayResultQuery="N0140";
	
	public static final String SHANDE_ORDER_CALLBACK = "C0420";// 杉德交易回调
	public static final String SHANDE_QUERY_SALE = "Q0240";// 杉德交易查询
}
