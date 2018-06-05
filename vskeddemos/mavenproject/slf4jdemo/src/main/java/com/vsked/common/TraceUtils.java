package com.vsked.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.MDC;

public class TraceUtils {
	
    public static final String TRACE_KEY = "mdc_trace_id";  
    public static final int TRACE_LENGTH = 16;
    
    public TraceUtils(){  
    }  
  
    public static void beginTrace(){  
        String traceId = RandomStringUtils.randomAlphanumeric(TRACE_LENGTH);  
        MDC.put(TRACE_KEY, traceId);  
    }  
  
    public static void beginTrace(String traceId){  
        MDC.put(TRACE_KEY, traceId);  
    }  
  
    public static void endTrace(){  
        MDC.remove(TRACE_KEY);  
    }  
  
    public static String getTraceIdKey(){  
        return (String)MDC.get(TRACE_KEY);  
    }  
}
