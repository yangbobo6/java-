package com.yangbo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*for (int i = 0; i < 10; i++) {
            new Thread(new MyThread()).start();
        }*/
        for (int i = 0; i < 10; i++) {
            MyThread1 myThread1 = new MyThread1();
            //适配器 ：FutureTasks
            FutureTask<String> futureTask = new FutureTask<>(myThread1);
            //放入到Thread中使用
            new Thread(futureTask,String.valueOf(i)).start();
            //获取返回值
            String s = futureTask.get();
            System.out.println("返回值"+s);
        }

    }
}
//Callable接口
class MyThread1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "String"+Thread.currentThread().getName();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
