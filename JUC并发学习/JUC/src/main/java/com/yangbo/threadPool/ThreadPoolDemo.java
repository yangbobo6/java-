package com.yangbo.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            //使用线程池后，使用线程池来创建线程
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"ok");
            });
        }
        //线程池用完，程序结束，关闭线程池
        threadPool.shutdown();
    }
}
