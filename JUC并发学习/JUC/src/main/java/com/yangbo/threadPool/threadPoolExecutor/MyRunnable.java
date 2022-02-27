package com.yangbo.threadPool.threadPoolExecutor;

import java.util.Date;

/**
 * @Author: yangbo
 * @Date: 2022-02-27-10:24
 * @Description:  这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"End.   Time = "+new Date());
    }

    public void processCommand(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
