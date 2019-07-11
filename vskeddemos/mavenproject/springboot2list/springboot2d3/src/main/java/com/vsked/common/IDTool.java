package com.vsked.common;

import org.apache.commons.lang3.RandomStringUtils;

public class IDTool {
	
	public static IdWorkerSnowflake uidWorker = new IdWorkerSnowflake();
	public static IdWorkerSnowflake webUidWorker = new IdWorkerSnowflake();
	public static IdWorkerSnowflake userBalanceHisidWorker = new IdWorkerSnowflake();
	public static IdWorkerSnowflake userPromotionBalanceHisidWorker = new IdWorkerSnowflake();
	
	/**
	 * 获取用户id
	 * @return
	 */
	public static long getAppUserId(){
		if(uidWorker==null){
			uidWorker = new IdWorkerSnowflake();
		}
		return uidWorker.nextId();
	}
	
	public static long getWebUserId(){
		if(webUidWorker==null){
			webUidWorker = new IdWorkerSnowflake();
		}
		return webUidWorker.nextId();
	}
	
	public static long getUserBalanceHisOrderId(){
		if(userBalanceHisidWorker==null){
			userBalanceHisidWorker = new IdWorkerSnowflake();
		}
		return userBalanceHisidWorker.nextId();
	}
	
	public static long getUserPromotionBalanceHisOrderId(){
		if(userPromotionBalanceHisidWorker==null){
			userPromotionBalanceHisidWorker = new IdWorkerSnowflake();
		}
		return userPromotionBalanceHisidWorker.nextId();
	}
	
	/**
	 * 获取app默认用户名
	 * @return
	 */
	public static String getAppUserName(){
		return "dy"+RandomStringUtils.randomAlphanumeric(5);
	}
	
	/**
	 * 获取邀请码
	 * @return
	 */
	public static String getMyInvitationCode(){
		return RandomStringUtils.randomAlphanumeric(5);
	}

}
