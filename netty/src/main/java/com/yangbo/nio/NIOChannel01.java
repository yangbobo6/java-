package com.yangbo.nio;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  2022/1/20
 *  channel 将一个字符串利用NIO的channel和buffer输入到一个1.txt文件中
 */
public class NIOChannel01 {
    public static void main(String[] args) throws Exception{
        String str = "nihao,zhuhzu";
        //创建buffer缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(50);
        //创建输出流  从buffer-->channel
        FileOutputStream fileOutputStream = new FileOutputStream("1.txt");
        FileChannel channel = fileOutputStream.getChannel();
        //在buffer放入信息
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        //写入到channel中
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
