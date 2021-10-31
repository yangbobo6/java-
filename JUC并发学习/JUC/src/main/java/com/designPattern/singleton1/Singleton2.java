package com.designPattern.singleton1;

public class Singleton2 {
    //私有无参构造
    private Singleton2(){};
    //指向自己实例 的私有静态引用
    private static Singleton2 singleton2=null;

    //以自己实例为返回值 的静态公有方法，静态工厂方法
    public static Singleton2 getInstance(){
        if(singleton2==null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }


}
