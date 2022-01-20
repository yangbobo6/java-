package com.yangbo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 本地文件读取  文件已经存在1.txt  读取到程序，显示在控制台
 */
public class NIOChannel02 {
    public static void main(String[] args) throws Exception{
        //创建文件，
        File file = new File("1.txt");
        //创建channel，将channel放到输入流中
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel channel = fileInputStream.getChannel();

        //创建缓冲区（长度为文件的大小）
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //将文件通过channel写入到缓冲区buffer中
        channel.read(buffer);
        //输出
        System.out.println(new String(buffer.array()));

        fileInputStream.close();
        
    }
}
