package com.yangbo.providerAndCons;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCProviderAndCon {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A线程").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B线程").start();
    }
}

//判断等待  业务  通知
class Data2{
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //+1
    public void increment() throws InterruptedException {
        //先用lock上锁
        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程，我+1已经完毕
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //-1
    public void decrement() throws InterruptedException{
        lock.lock();

        try {
            while(number==0){
                //不符合条件，等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程，已经完毕
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
