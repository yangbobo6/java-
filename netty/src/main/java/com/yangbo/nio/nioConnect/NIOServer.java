package com.yangbo.nio.nioConnect;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception{
        //创建ServerSocketChannel --> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建selector对象
        Selector selector = Selector.open();

        //绑定一个端口号
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到selector  关心 事件 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("一个接收通道生成");
        Set<SelectionKey> selectionKeys1 = selector.selectedKeys();
        System.out.println("第0次"+selectionKeys1.size());
        

        //循环等待客户连接
        while (true){
            //没有事件发生,不会堵塞到这里
            if(selector.select(1000)==0){
                //System.out.println("服务器等待了1s，无连接");
                continue;
            }
            //如果返回的不是0 ，说明有连接,获取到相关的selectionKeys集合
            //表示已经获取到关注的事件，通过selectKeys返回集合，再通过keys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("第一次获取"+selectionKeys.size());
            //遍历keys
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                //获取到每个key
                SelectionKey key = keyIterator.next();
                //根据不同的key做相应的处理
                if(key.isAcceptable()){ //如果是isAcceptable，表示有新的客户连接
                    //则该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    System.out.println("客户端连接成功，生成了一个socketChannel"+socketChannel.hashCode());
                    //将socketChannel注册到selector里面  可以在通道内绑定buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("读通道生成");
                    System.out.println("第二次"+selectionKeys.size());
                }

                

                if (key.isReadable()){ //如果key是一个读事件
                    //通过key反向获取通道channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println(buffer.array());
                    System.out.println(new String(buffer.array()));
                    System.out.println("from 客户端"+new String(buffer.array()));
                }
                //手动从集合中删除key，防止重复操作
                //keyIterator.remove();
            }
            System.out.println("移除key");
            keyIterator.remove();
            System.out.println("第三次"+selectionKeys.size());
        }
    }

}
