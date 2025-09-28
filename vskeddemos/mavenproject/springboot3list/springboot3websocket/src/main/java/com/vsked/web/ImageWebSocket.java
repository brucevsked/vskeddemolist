package com.vsked.web;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/imageWebsocket")
public class ImageWebSocket {

    private static final Logger log = LoggerFactory.getLogger(ImageWebSocket.class);

    private static List<Session> sessions = new CopyOnWriteArrayList<>();
    private static volatile boolean sending = false;
    private static Thread sendingThread = null;

    @OnOpen
    public void onOpen(Session session) {
        log.info("New connection: {}", session.getId());
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("Connection closed: {}", session.getId());
        Iterator<Session> it = sessions.iterator();
        Session s;
        while (it.hasNext()) {
            s = it.next();
            if (s.getId().equals(session.getId())) {
                it.remove();
            }
        }

        // 如果没有会话了，停止发送数据
        if (sessions.isEmpty()) {
            sending = false;
            if (sendingThread != null) {
                sendingThread.interrupt();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("Error: {}", throwable.getMessage());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("from client Received message: {}", message);

        // 如果已经在发送数据，则停止之前的发送任务
        if (sending) {
            sending = false;
            if (sendingThread != null) {
                try {
                    sendingThread.join(); // 等待线程结束
                } catch (InterruptedException e) {
                    log.error("Thread join interrupted: {}", e.getMessage());
                }
            }
        }

        // 启动新的发送任务
        sending = true;
        sendingThread = new Thread(() -> {
            while (sending) {
                try {
                    for (Session s : sessions) {
                        try {
                            log.info("to client send message: {}", s.getId());
                            log.info("is Open : {}", s.isOpen());

                            if (s.isOpen()) {
                                Random random=new Random();
                                //设置服务端要发送的消息
                                String msgToClient= LocalDateTime.now() +"from server send to client:"+random.nextInt(1000);
                                s.getBasicRemote().sendText(msgToClient);
                            } else {
                                // 如果会话已关闭，则从sessions中移除
                                sessions.remove(s);
                            }
                        } catch (Exception e) {
                            log.error("Error sending message: {}", e.getMessage());
                        }
                    }
                    Thread.sleep(1500); // 每隔1.5秒发送一次
                } catch (Exception e) {
                    log.info("Sending thread interrupted");
                    break;
                }
            }
        });
        sendingThread.start();
    }

}
