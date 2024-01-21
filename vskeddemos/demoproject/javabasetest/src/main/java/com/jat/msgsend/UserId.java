package com.jat.msgsend;

public class UserId {

    private Long id;

    public UserId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("用户唯一标识不能为空！");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return "" + id ;
    }
}
