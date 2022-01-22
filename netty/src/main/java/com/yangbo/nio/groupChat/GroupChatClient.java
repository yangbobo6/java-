package com.yangbo.nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {
    //定义相关的属性
    private final String HOST = "127.0.0.1";
    private final int PORT = 6667;
    private SocketChannel socketChannel;
    private String username;
    private Selector selector;

    //构造器
    public GroupChatClient() throws IOException {
        selector = Selector.open();
        //定义连接器   ------------------问题？？
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST,PORT));
        socketChannel.configureBlocking(false);
        //将channel注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        //username
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username+"is ok...");
    }

    //向服务器发送消息
    public void sendInfo(String info){
        info = username + "说" + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //读取服务器回复的消息
    public void readInfo(){
        try {
            //查看选择器中 哪个通道 有信息返回  阻塞在这里了（如果有别的工作要做，在else里面具体设置）
            int readChannels = selector.select();
            if(readChannels>0){ //有可用的通道
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    //得到该key的通道
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //读取通道的信息
                    channel.read(buffer);
                    //缓冲区转换成字符串
                    String msg = new String(buffer.array());
                    System.out.println(msg.trim());
                }
                iterator.remove();
            }else {
                //System.out.println("没有可用通道");

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        //建立客户端
        GroupChatClient chatClient = new GroupChatClient();

        //启动一个新的线程，每隔3秒从服务器端刷新读取数据
        new Thread(){
            public void run(){
                while (true){
                    chatClient.readInfo();
                    try {
                        Thread.currentThread().sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }

        }.start();

        //发送数据给服务器端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            chatClient.sendInfo(s);
        }

    }



}
