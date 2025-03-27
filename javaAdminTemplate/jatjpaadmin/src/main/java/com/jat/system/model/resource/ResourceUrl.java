package com.jat.system.model.resource;

public class ResourceUrl {

    private final String url;

    public ResourceUrl(String url) {

        if(url==null){
            throw new IllegalArgumentException("资源url不能为空！");
        }

        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return  url;
    }
}
