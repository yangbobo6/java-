package com.yangbo.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;

public class NettyServer{
    public static void main(String[] args) throws Exception {
        //创建bossGroup（处理链接请求）和workerGroup（客户端业务处理）
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来设计   (配置内容)
            bootstrap.group(bossGroup,workerGroup)   //设置两个线程组
                    .channel(NioServerSocketChannel.class)   //使用NioSocketChannel  作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG,128)   //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)  //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {  //创建一个通道测试对象
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ch.pipeline().addLast(new ServerNettyHandler());
                        }
                    });  //给workGroup的EventLoop对应的管道设置处理器

            System.out.println("服务器已经配置好了");
            //绑定一个端口并且同步，生成ChannelFuture对象
            //启动服务器
            ChannelFuture cf = bootstrap.bind(6668).sync();
            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
