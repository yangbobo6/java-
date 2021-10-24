package com.yangbo.lock8;
/*
* 两个线程谁先打印
* 打电话  还是  发短息
*
* 由于发短信先获取锁，所以会第一个输出
* 一个对象对应一把锁,两个对象对应两把锁
* */

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()->{
            try {
                phone.sendMs();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A线程").start();

        //休息 1s
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone1.call();
        },"B线程").start();

        new Thread(()->{
            phone.hello();
        },"C线程").start();

    }
}

class Phone{
    public synchronized void sendMs() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}
