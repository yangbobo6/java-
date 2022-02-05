package com.yangbo.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-02-05-16:28
 * @Description:
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder 被调用");

        // 得到二进制内容
        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);

        //封装成 MessageProtocol 对象，放入 out， 传递下一个handler业务处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(content);

        //放入out传给下一个handler进行处理
        out.add(messageProtocol);

    }
}
