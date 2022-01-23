package com.yangbo.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 自定义一个handler，需要继承netty，规定好某个HandlerAdapter
 */
public class ServerNettyHandler extends ChannelInboundHandlerAdapter  {
    //读取客户端发送的数据
    /*
    1.ChannelHandlerContext ctx:上下文对象，含有管道pipeline，通道channel，地址
    2.Object msg  客户端发送的内容 默认Object
     */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx = :"+ctx);
        //将msg转化为一个ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息是："+ buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址是："+ctx.channel().remoteAddress());

    }

    //数据库读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //writeAndFlush是write + flush
        //将数据写入缓存，并刷新,一般对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,tanjing",CharsetUtil.UTF_8));
    }

    //处理异常，关闭通道

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
