package com.jat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PageService {

    private static final Logger log = LoggerFactory.getLogger(PageService.class);
    private Integer pageIndex=0;
    private Integer pageSize=10;

    public PageService getPage(Map<String,Object> params){
        if(params.get("pageIndex")!=null){
            pageIndex= Integer.valueOf(params.get("pageIndex")+"") ;
            if(pageIndex>=1){
                pageIndex=pageIndex-1;
            }
        }
        if(params.get("pageSize")!=null){
            pageSize= Integer.valueOf(params.get("pageSize")+"");
        }
        return new PageService(pageIndex,pageSize);
    }

    public PageService() {
    }

    public PageService(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getLike(Object o){
        if(o==null){
            return "%";
        }
        return "%"+o+"%";
    }

    @Override
    public String toString() {
        return "{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
