package com.yangbo.netty.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @Author: yangbo
 * @Date: 2022-02-05-16:28
 * @Description:
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        //接收数据，并处理
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("服务器接收："+ "长度= "+len+"  内容"+content);

        //回复消息
        System.out.println("服务器回复消息");

        String respondContent = UUID.randomUUID().toString();
        int resLen = respondContent.getBytes("utf-8").length;
        byte[] responseContent2 = respondContent.getBytes("utf-8");
        //构建协议包
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(resLen);
        messageProtocol.setContent(responseContent2);
        //放入到通道
        ctx.writeAndFlush(messageProtocol);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
