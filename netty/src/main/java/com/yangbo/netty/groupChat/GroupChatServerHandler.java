package com.yangbo.netty.groupChat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String > {
    //定义一个channel组，管理所有的channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //handlerAdded 表示连接建立，第一个被执行
    //将当前channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户的聊天信息  推送给其他在线的客户端
        //该方法会遍历所有的channel，并发送消息
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+" 加入聊天"+sdf.format(new Date())+"/n");
        channelGroup.add(channel);
    }

    //断开连接，将xx客户离开的信息推送给当前在线的客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"离开了\n");
        System.out.println("channelGroup size "+channelGroup.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线了~");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"离线了~");
    }

    //核心  方法   读取写入
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取到当前的channel
        Channel channel = ctx.channel();

        //遍历我们的channelGroup，根据不同的情况，回送不同的消息
        channelGroup.forEach(ch->{
            if (channel != ch){  //不是当前的channel
                ch.writeAndFlush("[客户]"+channel.remoteAddress()+sdf.format(new Date())+
                        "发送了消息"+msg+ "\n");
            }else {
                ch.writeAndFlush("[自己]发送了消息"+msg+"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
    }
}
