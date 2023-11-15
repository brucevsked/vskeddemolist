package com.vsked.aop;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.MDC;

public class MDCTool {
	
    public static final String TRACE_KEY = "mdc_trace_id";
    public static final int TRACE_LENGTH = 16;

    public MDCTool(){
    }

    public static void beginTrace(){
        String traceId = RandomStringUtils.randomAlphanumeric(TRACE_LENGTH);
        MDC.put(TRACE_KEY, traceId);
    }

    public static String getTraceId(){
    	String traceId = RandomStringUtils.randomAlphanumeric(TRACE_LENGTH);
    	return traceId;
    }

    public static void beginTrace(String traceId){
        MDC.put(TRACE_KEY, traceId);
    }

    public static void endTrace(){
        MDC.remove(TRACE_KEY);
        MDC.clear();
    }

    public static String getTraceIdKey(){
        return (String)MDC.get(TRACE_KEY);
    }
}
