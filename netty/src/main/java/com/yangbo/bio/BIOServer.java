package com.yangbo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        /**
         * 线程机制
         * 1.创建一个线程池
         * 2.如果有客户端连接就创建一个线程，与之通讯（单独写一个方法）
         *
         */
        //创建一个线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建serverSocket,监听端口
        ServerSocket serverSocket = new ServerSocket(6666);
        //服务器启动
        System.out.println("服务器启动");
        while(true){
            System.out.println("线程 id:"+Thread.currentThread().getId()+"  名字:"+
                    Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待线程连接--------");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //创建一个线程，与之通讯（单独写一个方法）
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //可以和客户端通讯
                    handler(socket);
                }
            });

        }


    }

    //编写一个handler方法，与客户端通讯
    public static void handler(Socket socket){
        try {
            System.out.println("线程 id:"+Thread.currentThread().getId()+"  名字:"+
                    Thread.currentThread().getName());

            //用来接收数据
            byte[] bytes = new byte[1024];
            //通过socket获得一个输入流
            InputStream inputStream = socket.getInputStream();

            //循环的读取客户端发送的数据
            while(true){
                System.out.println("线程 id:"+Thread.currentThread().getId()+"  名字:"+
                        Thread.currentThread().getName());
                //把数据读取到bytes里面去
                System.out.println("socket没有读取到数据，阻塞中read......");
                int read = inputStream.read(bytes);
                //System.out.println("socket没有读取到数据，阻塞中read......");
                if(read!=-1){
                    //如果还没有读取完   输出  bytes里面从0 -> read
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //关闭和client的连接
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
