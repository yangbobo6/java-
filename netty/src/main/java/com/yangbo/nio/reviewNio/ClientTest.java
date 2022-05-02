package com.yangbo.nio.reviewNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yangbo
 * @Date: 2022-04-30-11:22
 * @Description:
 */
public class ClientTest {

    public static void client(){
        SocketChannel socketChannel = null;
        try{
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8888));
            if(socketChannel.finishConnect()){
                int i = 0;
                while(true){
                    TimeUnit.SECONDS.sleep(1);
                    String info = "this is "+i++ +"-th information from client";
                    ByteBuffer buffer = ByteBuffer.wrap(info.getBytes());
                    socketChannel.write(buffer);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        
    }

    public static void main(String[] args) {
        ClientTest.client();
    }
    
    
    
}
