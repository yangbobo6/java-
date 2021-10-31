package com.designPattern.FactoryPattern;
//简单的工厂模式

//做饭接口
interface Restaurant3{
    public void cook3();
}

class Meet3 implements Restaurant3{
    @Override
    public void cook3() {
        System.out.println("小炒肉");
    }
}

class Fish3 implements Restaurant3{
    @Override
    public void cook3() {
        System.out.println("🐟肉");
    }
}

class Duck3 implements Restaurant3{
    @Override
    public void cook3() {
        System.out.println("北京考🦆");
    }
}
//抽象工厂类
abstract class CookFactory2{
    public abstract Restaurant3 createRestaurant();
}

//其实现类
class DuckFactory extends CookFactory2{

    @Override
    public Restaurant3 createRestaurant() {
        return new Duck3();
    }
}

class FishFactory extends CookFactory2{

    @Override
    public Restaurant3 createRestaurant() {
        return new Fish3();
    }
}


public class FactoryMethod{
    public static void main(String[] args) {
        Restaurant3 fish = new FishFactory().createRestaurant();
        fish.cook3();

    }
}
