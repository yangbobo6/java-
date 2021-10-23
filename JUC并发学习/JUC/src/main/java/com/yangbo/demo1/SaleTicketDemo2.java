package com.yangbo.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo2 {
    public static void main(String[] args) {
        //并发   多线程操作一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();
        //@FunctionalInterface 函数式接口，jdk1.8 Lambda表达式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    ticket.sale();
                }
            }
        },"A 线程").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        },"B 线程").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        },"C 线程").start();

    }

}

//资源类  OOP
class Ticket2{
    //属性  方法
    private int number = 50;

    Lock lock = new ReentrantLock();

    //卖票的方式
    public synchronized void sale(){
        //锁的使用   加锁，然后再finally中解锁
        lock.lock();

        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票,剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
