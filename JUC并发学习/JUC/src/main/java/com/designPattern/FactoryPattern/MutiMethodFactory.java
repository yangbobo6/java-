package com.designPattern.FactoryPattern;

interface Restaurant1{
    public void cook1();
}

class Meet1 implements Restaurant1{
    String param;
    public Meet1(String param){
        this.param = param;
    }
    @Override
    public void cook1() {
        System.out.println("小炒肉");
    }
}

class Duck1 implements Restaurant1{

    @Override
    public void cook1() {
        System.out.println("北京烤鸭🦆");
    }
}

class Fish1 implements Restaurant1{

    @Override
    public void cook1() {
        System.out.println("🐟");
    }
}
//工厂类
class FactoryClass{
    public static Restaurant1 createMeet(String param){
        return new Meet1(param);
    }
    public static Restaurant1 createFish(){
        return new Fish1();
    }
    public static Restaurant1 createDuck(){
        return new Duck1();
    }
}

public class MutiMethodFactory {
    public static void main(String[] args) {
        Restaurant1 meetCooker = FactoryClass.createMeet("三分熟");
        meetCooker.cook1();

        Restaurant1 fishCooker = FactoryClass.createFish();
        fishCooker.cook1();
    }
}
