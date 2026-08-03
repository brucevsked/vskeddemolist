package com.vsked.tool;

import org.slf4j.MDC;
import java.security.SecureRandom;

public class MDCTool {
	
    public static final String TRACE_KEY = "mdc_trace_id";
    public static final int TRACE_LENGTH = 16;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateTraceId(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public MDCTool(){
    }

    public static void beginTrace(){
        String traceId = generateTraceId(TRACE_LENGTH);
        MDC.put(TRACE_KEY, traceId);
    }

    public static String getTraceId(){
    	return generateTraceId(TRACE_LENGTH);
    }

    public static void beginTrace(String traceId){
        MDC.put(TRACE_KEY, traceId);
    }

    public static void endTrace(){
        MDC.remove(TRACE_KEY);
        MDC.clear();
    }

    public static String getTraceIdKey(){
        return MDC.get(TRACE_KEY);
    }

}
