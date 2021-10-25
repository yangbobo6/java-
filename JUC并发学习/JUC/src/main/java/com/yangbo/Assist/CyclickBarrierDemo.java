package com.yangbo.Assist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclickBarrierDemo {
    public static void main(String[] args) {
        //当线程数量为7个时，才执行召唤神龙
        CyclicBarrier cyclicBarrier = new CyclicBarrier(18,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <= 20; i++) {
            int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 收集了第 {"+ temp+"} 颗龙珠");
                try {
                    cyclicBarrier.await();  //加法计数等待
                    System.out.println("------"+temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
