package com.designPattern.FactoryPattern;
//抽象工厂模式

interface AbstractFactory{
    Phone createPhone(String param);
    Mask createMasks(String param);
}
interface Phone{}
class IPhone implements Phone{}

interface Mask{}
class N95Mask implements Mask{}

//具体工厂
class SuperFactory implements AbstractFactory{

    @Override
    public Phone createPhone(String param) {
        System.out.println(param+"iphone");
        return new IPhone();
    }

    @Override
    public Mask createMasks(String param) {
        System.out.println(param+"口罩");
        return new N95Mask();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory = new SuperFactory();
        factory.createMasks("");
        SuperFactory superFactory = new SuperFactory();
        superFactory.createMasks("n95");
        superFactory.createPhone("iphoneX");
    }

}
