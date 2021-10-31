package com.designPattern.singleton1;
//双重加锁机制
public class Singleton3 {
    private Singleton3(){};

    private static volatile Singleton3 singleton3 = null;
    //程序运行时  加载对象
    private static Singleton3 getInstance(){
        if(singleton3 == null){
            synchronized (Singleton3.class){
                if(singleton3==null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
