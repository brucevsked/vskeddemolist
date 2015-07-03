package com.vsked.lesson1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


public class HelloClientIntHandler extends ChannelHandlerAdapter {

	// 接收server端的消息，并打印出来
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		System.out.println("Server said:" + new String(result1));
		result.release();
	}

	// 连接成功后，向server发送消息
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String msg = "this is client msg?";
		ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
		encoded.writeBytes(msg.getBytes());
		ctx.write(encoded);
		ctx.flush();
	}
}

