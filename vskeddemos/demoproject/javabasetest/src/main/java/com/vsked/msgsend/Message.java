package com.vsked.msgsend;

public class Message {

    private MessageId id;
    private MessageContent content;

    public MessageId getId() {
        return id;
    }

    public MessageContent getContent() {
        return content;
    }

    public Message(MessageId id, MessageContent content) {
        this.id = id;
        this.content = content;
    }

    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"content\":\"" + content +"\""+
                "}";
    }
}
