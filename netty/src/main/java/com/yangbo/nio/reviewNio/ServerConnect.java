package com.yangbo.nio.reviewNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

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
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try{
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false);
            ssc.register(selector,SelectionKey.OP_ACCEPT);
            while(true){
                if(selector.select(TIMEOUT)==0){
                    System.out.println("===");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        handleAccept(key);
                    }
                    if (key.isReadable()){
                        handleRead(key);
                    }
                    if (key.isWritable()&&key.isValid()){
                        handWrite(key);
                    }
                    if (key.isConnectable()){
                        System.out.println("connect is true");
                    }
                    iter.remove();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(selector!=null){
                    selector.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
