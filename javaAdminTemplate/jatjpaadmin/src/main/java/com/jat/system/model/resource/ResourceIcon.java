package com.jat.system.model.resource;

public class ResourceIcon {

    private final String icon;

    public ResourceIcon(String icon) {

        if(icon==null){
            throw new IllegalArgumentException("资源图标不能为空！");
        }

        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return  icon;
    }
}
