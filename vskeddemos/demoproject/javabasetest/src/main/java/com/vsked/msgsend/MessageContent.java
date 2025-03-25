package com.vsked.msgsend;

public class MessageContent {

    private String content;

    public MessageContent(String content) {
        if(content==null){
            throw new IllegalArgumentException("消息内容不能为空！");
        }

        String contentTrim=content.replace(" ","");
        if("".equals(contentTrim)){
            throw new IllegalArgumentException("消息内容不能为空字符串！");
        }

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return content ;
    }
}
