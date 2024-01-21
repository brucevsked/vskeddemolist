package com.jat.msgsend;

public class MessageId {
    private Long id;

    public MessageId(Long id) {
        if(id==null){
            throw new IllegalArgumentException("消息唯一标识不能为空！");
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
