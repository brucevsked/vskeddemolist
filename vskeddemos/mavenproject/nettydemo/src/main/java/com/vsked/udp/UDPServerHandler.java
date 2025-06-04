package com.vsked.udp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UDPServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger log = LoggerFactory.getLogger(UDPServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {
        // 获取接收到的数据
        String received = packet.content().toString(CharsetUtil.UTF_8);
        log.info("收到 UDP 消息: {}", received);

        // 原样响应给发送方
        ByteBuf response = Unpooled.copiedBuffer(received.getBytes(CharsetUtil.UTF_8));
        ctx.writeAndFlush(new DatagramPacket(response, packet.sender()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("----------UDPServer出现异常", cause);
        ctx.close();
    }
}
