package com.jat.bo;

public class PlatformCertificateId {

    private Long id;

    public PlatformCertificateId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("凭证编号不能为空！");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return ""+ id;
    }
}
