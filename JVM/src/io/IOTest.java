package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: yangbo
 * @Date: 2022-02-21-11:31
 * @Description:
 */
public class IOTest {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\yangbo\\a.txt");

        InputStream inputStream = new FileInputStream(file);
        int read = inputStream.read();
        System.out.println(read);

        System.out.println((char) read);

        byte[] bytes = new byte[16];
        inputStream.read(bytes);
        System.out.println(new String(bytes));

        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write("tanzhuzhu".getBytes(StandardCharsets.UTF_8));

        inputStream.close();
        outputStream.close();

    }
}
