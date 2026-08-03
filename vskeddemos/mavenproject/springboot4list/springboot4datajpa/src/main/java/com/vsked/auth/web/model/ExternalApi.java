package com.vsked.auth.web.model;

public class ExternalApi {

    private String name;
    private String url;

    public ExternalApi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ExternalApi{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
