package com.jat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint("/websocket.ws/{userId}")
public class WebSocket {

    private static final Logger log = LoggerFactory.getLogger(WebSocket.class);

    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String userId;

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {

        this.userId = userId;
        this.session = session;

        clients.put(userId, this);
        //System.out.println("已连接");
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(userId);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("{}",message);
        // message是json格式
        /*
        JSONObject obj = JSONObject.parseObject(message);
        String user = obj.get("userId").toString();
        String mes = obj.get("message").toString();
        // 判断是否在线，如果在线发送信息
        for (WebSocket item : clients.values()) {
            if (item.userId.equals(user)) {
                item.session.getAsyncRemote().sendText(mes);
            }
        }
         */
    }
}
