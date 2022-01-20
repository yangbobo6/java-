package com.yangbo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 实例3  只通过fileChannel和read和write方法，完成文件的拷贝
 * 拷贝一个 1.txt文件，放在项目下
 */
public class NIOChannel03 {
    public static void main(String[] args) throws Exception{
        File file = new File("1.txt");

        //创建输入流 以及channel1
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel1 = fileInputStream.getChannel();

        //输出流以及通道 channel2
        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel2 = fileOutputStream.getChannel();

        //创建缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //将文件中所有 内容输入到buffer中
        while (true){
            //缓冲区buffer指针数归0
            buffer.clear();
            int read = fileChannel1.read(buffer);
            if(read==-1){
                break;
            }
            buffer.flip();
            fileChannel2.write(buffer);
        }
        //关闭channel
        fileChannel1.close();
        fileChannel2.close();

    }

}
