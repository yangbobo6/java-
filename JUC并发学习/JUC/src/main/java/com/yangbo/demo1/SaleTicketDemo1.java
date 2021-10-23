package com.yangbo.demo1;

public class SaleTicketDemo1 {
    public static void main(String[] args) {
        //并发   多线程操作一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();
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
class Ticket{
    //属性  方法
    private int number = 50;
    //卖票的方式
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票,剩余：" + number);
        }
    }

}
