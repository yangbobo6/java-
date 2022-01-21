package com.yangbo.nio.nioConnect;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws Exception{
        //输入一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        //提供服务器的端口号和ip地址
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if(!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){   //如果没有连接，也不会在这里阻塞
                System.out.println("因连接需要时间，客户端不会阻塞，可以做其他工作..");
            }
        }
        String str = "zhuzhu chuan gaogen";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        //发送数据到，将buffer数据写入到channel
        socketChannel.write(buffer);
        System.in.read();

    }
}
