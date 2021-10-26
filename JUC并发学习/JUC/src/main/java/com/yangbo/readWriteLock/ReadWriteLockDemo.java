package com.yangbo.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        MyCatchLock myCatchLock = new MyCatchLock();
        //写入
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(()->{
                myCatchLock.put(temp+"",temp+"");

            },String.valueOf(i)).start();
        }

        //读取
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(()->{
                myCatchLock.get(temp+"");
            },String.valueOf(i)).start();

        }
    }
}
class MyCache{
    private volatile Map<String ,Object> map = new HashMap<>(0);
    //存值
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+value);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入成功");
    }
    //取值
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"取值"+key);
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"取值成功");
    }
}

//加锁的
class MyCatchLock {
    private volatile Map<String,Object> map = new HashMap<>(0);
    //读写锁更加细粒度的控制
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock lock1 = new ReentrantLock();

    //存,写的时候,只希望同时有一个线程写
    public void put(String key,Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+value);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    //取,读,所有的人都可以读
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
