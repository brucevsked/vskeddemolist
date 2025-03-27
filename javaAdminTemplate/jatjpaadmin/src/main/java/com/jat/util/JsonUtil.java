package com.jat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    static ObjectMapper jackson = new ObjectMapper();

    public static String objectToJson(Object object) throws JsonProcessingException {
        return jackson.writeValueAsString(object);
    }


}
