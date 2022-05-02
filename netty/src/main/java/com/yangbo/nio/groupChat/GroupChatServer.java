package com.yangbo.nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 群聊系统  服务器端
 *
 * channel --> buffer   read
 * buffer --> channel  write
 */
public class GroupChatServer {
    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    //构造器  初始化工作
    public GroupChatServer(){
        try {
            //得到选择器  和监听channel
            selector = Selector.open();
            System.out.println(selector.hashCode());
            listenChannel = ServerSocketChannel.open();
            //绑定端口号
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将通道注册到选择器里面
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //监听
    public void listen(){
        try{
            //循环处理
            while(true){
                //判断是否监听到
                int count = selector.select(2000);
                if(count>0){  //监听到，有事件处理
                    //可能有多个事件   遍历的到所有selectionKey，对每一个selectionKey进行处理
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while(iterator.hasNext()){
                        //取出selectionKey
                        SelectionKey key = iterator.next();

                        //监听到accept
                        if(key.isAcceptable()){
                            //生成一个socketChannel ***注意
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            //将sc注册到selector里面
                            sc.register(selector,SelectionKey.OP_READ);
                            //提示
                            System.out.println(sc.getRemoteAddress()+"上线"+"   listenChannel连接通道是"+sc.hashCode());
                        }

                        if(key.isReadable()){ //发送的是read事件，  通道是可读状态
                            //处理读（专门写一个方法）
                            readData(key);
                        }
                        //处理完后，将该key删除
                        iterator.remove();
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //发生异常处理

        }
    }
    //读取客户端消息
    private void readData(SelectionKey key){
        //得到关联的channel
        SocketChannel channel = null;
        try{
            //很具key获取一个channel
            channel = (SocketChannel)key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(100);

            int count = channel.read(buffer);
            //判断读取信息是否为空
            if(count>0){
                //把缓冲区的数据转换为字符串
                String msg = new String(buffer.array());

                //输出该消息
                System.out.println("from 客户端"+msg+"  读取客户端通道readChannel"+channel.hashCode());

                //向其他客户端转发消息(排除自己)，专门写一个方法来执行
                sendInfoToOtherClient(msg,channel);
            }
        }catch (IOException e){
            try {
                System.out.println(channel.getRemoteAddress()+"离线了");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

    //转发消息给其他客户
    private void sendInfoToOtherClient(String msg,SocketChannel self) throws IOException{
        System.out.println("消息转发中");
        //遍历所有注册到selector中上的SocketChannel
        for (SelectionKey key:selector.keys()
             ) {
            //通过key 取出对应的SocketChannel
            Channel targetChannel = key.channel();
            //排除自己
            if(targetChannel instanceof SocketChannel && targetChannel!=self){
                //转型
                SocketChannel dest = (SocketChannel)targetChannel;
                //将msg存储到buffer中
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer中数据  写入通道
                dest.write(buffer);

            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.listen();
    }


}
