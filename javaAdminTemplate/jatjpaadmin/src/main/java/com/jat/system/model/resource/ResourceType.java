package com.jat.system.model.resource;

public class ResourceType {

    private final String type;

    public ResourceType(String type) {

        if(type==null){
            throw new IllegalArgumentException("资源类型不能为空！");
        }

        String trimName=type.replace(" ","");
        if("".equals(trimName)){
            throw new IllegalArgumentException("资源类型不能为空字符串！");
        }

        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
