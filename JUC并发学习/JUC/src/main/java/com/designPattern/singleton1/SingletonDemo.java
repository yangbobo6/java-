package com.designPattern.singleton1;

//饿汉式
public class SingletonDemo {
    //私有的构造方法，保证别人不能创建
    private SingletonDemo(){};
    //指向自己实例的私有静态引用
    private static SingletonDemo singletonDemo = new SingletonDemo();

    //以自己实例为返回值  的静态的公有方法
    public static SingletonDemo getSingleton(){
        return singletonDemo;
    }
}
