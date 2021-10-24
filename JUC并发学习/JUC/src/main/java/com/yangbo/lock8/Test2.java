package com.yangbo.lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Phone1 phone1 = new Phone1();
        //创建线程
        new Thread(()->{
            try {
                phone1.sendMs();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A线程").start();

        //休息 1s
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone1.call();
        },"B线程").start();
    }
}

class Phone1{
    public static synchronized void sendMs() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}