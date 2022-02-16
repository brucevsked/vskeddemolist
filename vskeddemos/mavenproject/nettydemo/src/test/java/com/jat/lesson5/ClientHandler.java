package com.jat.lesson5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.Date;


public class ClientHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel Registered, Client.");
        ctx.fireChannelRegistered();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        System.out.println("channelActive.");
        String clientMsg="ping";
        ByteBuf clientMsgByteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(clientMsg,CharsetUtil.UTF_8));
        ctx.channel().writeAndFlush(clientMsgByteBuf.duplicate());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("Handler added.");
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //接收msg消息
        ByteBuf buf = (ByteBuf) msg;
        byte[] msgByte = new byte[buf.readableBytes()];
        buf.readBytes(msgByte);
        System.out.print(new Date() + "客户端接收到消息：");
        String receiveMsg=new String(msgByte, Charset.forName("UTF-8"));
        System.out.println(receiveMsg);
        if("pong".equals(receiveMsg)){
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }

            String clientMsg="ping";
            ByteBuf clientMsgByteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(clientMsg, CharsetUtil.UTF_8));
            ctx.channel().writeAndFlush(clientMsgByteBuf.duplicate());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
