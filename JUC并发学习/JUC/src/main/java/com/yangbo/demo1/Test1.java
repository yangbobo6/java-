package com.yangbo.demo1;

public class Test1 {
    public static void main(String[] args) {
        //获取cpu的核数
        //cpu 密集型   io密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
