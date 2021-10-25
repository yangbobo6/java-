package com.yangbo.Assist;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "Go out");
                count.countDown(); //每个线程数减一
            }, String.valueOf(i)).start();
        }
        //count.await();  //等待计数器归0  然后向下执行
        System.out.println("close door");

    }
}
