package com.yangbo.netty.protocoltcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: yangbo
 * @Date: 2022-02-05-21:35
 * @Description:
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MyMessageDecoder());
        pipeline.addLast(new MyMessageEncoder());
        pipeline.addLast(new MyClientHandler());
    }
}
