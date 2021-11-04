package com.designPattern.FactoryPattern;
//简单的工厂模式

//做饭接口
interface Food{
    public void cook3();
}

class Meet3 implements Food{
    @Override
    public void cook3() {
        System.out.println("小炒肉");
    }
}

class Fish3 implements Food{
    @Override
    public void cook3() {
        System.out.println("🐟肉");
    }
}

class Duck3 implements Food{
    @Override
    public void cook3() {
        System.out.println("北京考🦆");
    }
}
//抽象工厂类
abstract class CookFactory2{
    public abstract Food createRestaurant();
}

//其实现类
class DuckFactory extends CookFactory2{

    @Override
    public Food createRestaurant() {
        return new Duck3();
    }
}

class FishFactory extends CookFactory2{

    @Override
    public Food createRestaurant() {
        return new Fish3();
    }
}


public class FactoryMethod{
    public static void main(String[] args) {
        CookFactory2 factory2 = new DuckFactory();
        Food duck = factory2.createRestaurant();
        duck.cook3();


        Food fish = new FishFactory().createRestaurant();
        fish.cook3();
    }
}
