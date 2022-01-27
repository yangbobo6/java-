package com.yangbo.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class NettyByteBuf {
    public static void main(String[] args) {
        //创建ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("HelloWorld!", Charset.forName("utf-8"));
        //使用相关方法
        if(byteBuf.hasArray()){
            byte[] content = byteBuf.array();
            //将content转化成字符串
            System.out.println(new String(content,Charset.forName("utf-8")));

            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());

            System.out.println(byteBuf.getByte(0));
            System.out.println(byteBuf.readableBytes());
        }
    }
}
