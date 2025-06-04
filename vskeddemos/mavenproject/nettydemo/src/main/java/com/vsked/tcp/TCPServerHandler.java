package com.vsked.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger log = LoggerFactory.getLogger(TCPServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msgByteBuf) {
        byte[] data = new byte[msgByteBuf.readableBytes()];
        msgByteBuf.readBytes(data);
        // 原样响应接收到的数据
        ctx.writeAndFlush(Unpooled.wrappedBuffer(data));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("----------TCPServer出现异常", cause);
        ctx.close();
    }

}
