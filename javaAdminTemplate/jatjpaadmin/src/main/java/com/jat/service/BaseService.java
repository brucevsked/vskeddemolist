package com.jat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class BaseService {
    private static final Logger log = LoggerFactory.getLogger(BaseService.class);

    public String getStr(Object o){
        log.trace("getStr");
        return o==null?"":o.toString();
    }

    public Integer getInt(Object o){
        log.trace("getInt");
        return o==null?null:Integer.valueOf(o.toString());
    }

    public List<Integer> getIntList(Object o){
        log.trace("getIntList");
        return o==null?new LinkedList<>() :(List<Integer>) o;
    }
}
