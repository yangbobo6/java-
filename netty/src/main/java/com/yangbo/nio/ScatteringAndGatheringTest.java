package com.yangbo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 2022/1/20 16:45
 * scattering : 将数据写入到buffer时，可以采用buffer数组，依此写入
 * gathering ： 将数据buffer读取数据时，可以采用buffer数组，依此读出
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws Exception{
        //使用serverSocketChannel 和 SocketChannel 网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口号到socket,并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        System.out.println("等待客户端连接");

        //等待客户端连接（telnet）
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("连接成功");
        int messageLength = 8;
        //循环的读取
        while ((true)){
            int byteRead = 0;
            while ((byteRead<messageLength)){
                //通道channel读取（client发送到channel）
                long l = socketChannel.read(byteBuffers);
                byteRead += l;  //累计读取的字节
                System.out.println("byteRead ="+byteRead);
                //使用流打印，看看当前的这个buffer的position和limit
                Arrays.asList(byteBuffers).stream().map(buffer -> "position="+
                        buffer.position()+", limit="+buffer.limit()).forEach(System.out::println);
            }
            //将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //将数据读出显示到客户端
            long byteWrite = 0;
            while(byteWrite<messageLength){
                long l = socketChannel.write(byteBuffers);
                byteWrite += l;
            }

            //将所有的buffer 进行clear
            Arrays.asList(byteBuffers).forEach(buffer -> {
                buffer.clear();
            });
            System.out.println("byteRead:="+byteRead+",byteWrite="+byteWrite+", messageLength"+messageLength);

        }
    }
}
