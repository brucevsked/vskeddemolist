package com.vsked.udp;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UDPServer {

    private static final Logger log = LoggerFactory.getLogger(UDPServer.class);
    private static final int PORT = 12385;

    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChannelInitializer<NioDatagramChannel>() {
                        @Override
                        protected void initChannel(NioDatagramChannel ch) {
                            ch.pipeline().addLast(new UDPServerHandler());
                        }
                    });

            ChannelFuture future = bootstrap.bind(PORT).sync();
            log.info("UDP Server 启动，监听端口: {}", PORT);

            future.channel().closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }
    }

}