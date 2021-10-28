package com.yangbo.threadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//银行满了还有人进来，不处理这个人，抛出异常
                //new ThreadPoolExecutor.DiscardPolicy()//队列满了不会抛出异常，丢掉任务
                //new ThreadPoolExecutor.CallerRunsPolicy()//哪里来的去哪里
                //new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试去和最早得竞争，也不会抛出异常
        );
        //最大承载：队列+max值
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
