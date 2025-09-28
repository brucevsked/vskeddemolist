"use strict"

class Index2 {

    baseWebsocketServerUrl = "ws://127.0.0.1:80/imageWebsocket";
    websocket = null;

    initUI() {
    }

    initEvent() {
        $("#runStateBt").on("click", () => {
            if ($("#runStateBt").html() === "开始") {
                console.log("hello");
                $("#runStateBt").html("停止");
                this.initWebsocketConnect();
            } else {
                console.log("bye");
                $("#runStateBt").html("开始");
                if (this.websocket) {
                    this.websocket.close();
                    this.websocket = null;
                }
            }
        });
    }

    initWebsocketConnect(){
        // 如果已有连接，先关闭
        if (this.websocket) {
            this.websocket.close();
        }

        // 创建WebSocket连接
        this.websocket = new WebSocket(this.baseWebsocketServerUrl);

        // 监听WebSocket连接打开
        this.websocket.onopen = (event) => {
            console.log("WebSocket连接已建立");
            // 连接建立后发送消息以启动服务端的数据发送
            this.websocket.send("start monitor");
        };

        // 监听WebSocket消息
        this.websocket.onmessage = (event) => {
            // 将接收到的数据显示到控制台上
            console.log("WebSocket消息:", event.data);
            $("#contentDiv").html(event.data+"<br>"+$("#contentDiv").html());

        };

        // 监听WebSocket连接关闭
        this.websocket.onclose = (event) => {
            console.log("WebSocket连接已关闭");
        };

        // 监听WebSocket错误
        this.websocket.onerror = (error) => {
            console.error("WebSocket错误:", error);
        };
    }

}

$(document).ready(function () {
    const index = new Index2();
    index.initUI();
    index.initEvent();
});
