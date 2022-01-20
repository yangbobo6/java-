package com.yangbo.nio;

import java.nio.IntBuffer;

public class basicBuffer {
    public static void main(String[] args) throws Exception{
        //举例说明  buffer的基础使用  创建一个buffer  容量大小为5
        IntBuffer intBuffer = IntBuffer.allocate(5);

        //循环向buffer中添加数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i*2);
        }
        //从buffer中读取数据
        //将buffer的写入数据转换为读取数据
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }
}
