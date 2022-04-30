package com.yangbo.nio.reviewNio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: yangbo
 * @Date: 2022-04-30-17:06
 * @Description:   NIO服务端  select连接等
 */
public class ServerConnect {
    private static final int BUF_SIZE = 1024;
    private static final int PORT = 8888;
    private static final int TIMEOUT = 3000;
    
    {
        selector();
    }
    
    public static void handleAccept(SelectionKey key)throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
        
    }
    
    public static void handleRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel)key.channel();
        ByteBuffer buffer = (ByteBuffer)key.attachment();
        long byteRead = sc.read(buffer);
        while(byteRead>0){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get() );
            }
            System.out.println();
            buffer.clear();
            byteRead = sc.read(buffer);
        }
        if(byteRead==-1){
            sc.close();
        }
    }
    
    public static void handWrite(SelectionKey key)throws IOException{
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel)key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }
    
    public static void selector(){
        
    }
}
