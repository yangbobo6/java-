package com.yangbo.providerAndCons;

/**
 * 传统的生产者消费者问题    synchronized
 * 线程之间的通信问题：生产者消费者问题 ！   等待唤醒，通知唤醒
 * 线程交替执行 A  B  操作同一个变量 num = 0
 * A num + 1
 * B num - 1
 */
public class providerAndConsumer {
    public static void main(String[] args) {
        Data data = new Data();
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
class Data{
    private int number = 0;
    //+1
    public synchronized void increment() throws InterruptedException {
        if(number!=0){
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程，我+1已经完毕
        this.notifyAll();
    }
    //-1
    public synchronized void decrement() throws InterruptedException{
        if(number==0){
            //等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notifyAll();
    }
}
