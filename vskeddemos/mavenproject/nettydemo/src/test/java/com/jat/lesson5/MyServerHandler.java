package com.jat.lesson5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.Date;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收msg消息
        ByteBuf buf = (ByteBuf) msg;
        byte[] msgByte = new byte[buf.readableBytes()];
        buf.readBytes(msgByte);
        System.out.print(new Date() + "服务端接收到消息：");
        String receiveMsg=new String(msgByte, Charset.forName("UTF-8"));
        System.out.println(receiveMsg);
        if("ping".equals(receiveMsg)){
            String serverMsg="pong";
            ByteBuf serverMsgByteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(serverMsg, CharsetUtil.UTF_8));
            ctx.channel().writeAndFlush(serverMsgByteBuf.duplicate());
        }
    }

}
