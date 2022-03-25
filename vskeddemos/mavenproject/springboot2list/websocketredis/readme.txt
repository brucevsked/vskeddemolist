特别注意
请先安装lombok插件!

websocket通过redis订阅实现消息推送

启动类
com.vsked.Application
配置文件
src/main/resources/application-dev.yml
测试文件
/src/test/java/com/vsked/service/目录中html文件

http://127.0.0.1:8181/testsend


技术原理
第一步
ServerWebSocket1类中
onOpen方法建立连接
第二步
将会话放入本地map
SysConstant.webSocketSessionMap.put(token, session);
第三步
ServerWebSocket1类中
onMessage方法发送消息
redisTemplate.convertAndSend(SysConstant.webSocketChannel, msg);
消息扔到redis中
第四步
redis监听器监听到消息改变
RedisSubListenerConfig
第五步
RedisReceiver类处理消息发送情况








如果只是服务端推送还可以选择SSE (Server-Sent Event)
https://blog.csdn.net/seek_of/article/details/80466362
package com.example.huamao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/** SSE 服务器发送事件
 */
@Controller
public class SSEController {
    @RequestMapping(value="/push",produces="text/event-stream;charset=utf-8")
    @ResponseBody
    public String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
    }
    @RequestMapping(value = "/sseTest", method = RequestMethod.GET)
    public String getSSEView () {
        return "sseTest";
    }
}


<html>
<head>
    <title>sse 测试</title>
</head>
<body>


<div id="msg_from_server"></div>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    if (!!window.EventSource) {
        var source = new EventSource('push'); //为http://localhost:8080/testSpringMVC/push
        s = '';
        source.addEventListener('message', function (e) {

            s += e.data + "<br/>"
            $("#msg_from_server").html(s);

        });

        source.addEventListener('open', function (e) {
            console.log("连接打开.");
        }, false);

        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            } else {
                console.log(e.readyState);
            }
        }, false);
    } else {
        console.log("没有sse");
    }
</script>


</body>
</html>
