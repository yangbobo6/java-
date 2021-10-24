package com.yangbo.providerAndCons;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* lock锁和synchronized的区别
* lock可以具体的唤醒哪一个
* A执行完调用B
* B执行完调用C
* C执行完调用A
* */
public class LockCondition {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data3.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data3.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data3.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C线程").start();
    }

}

//资源类
class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int number = 1;

    public void printA() throws InterruptedException {
        lock.lock();
        //业务  判断 -》 执行 -》 通知
        try {
            while(number!=1){
                //线程等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"--》线程A");
            //线程开启
            number=2;
            condition2.signal();  //唤醒2
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException{
        lock.lock();
        try {
            while(number!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"--》线程B");
            number=3;
            condition3.signal();  //唤醒3
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException{
        lock.lock();
        try {
            while(number!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"--》线程C");
            number=1;
            condition1.signal();  //唤醒3
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
