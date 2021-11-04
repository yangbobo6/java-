package com.designPattern.FactoryPattern;
//抽象工厂模式

interface AbstractFactory{
    Phone createPhone(String param);
    Mask createMasks(String param);
}

//具体手机  口罩的用途
interface Phone{
    public void print();
}
class IPhone implements Phone{
    @Override
    public void print() {
        System.out.println("This is an iphone");
    }
}

interface Mask{
    public void wear();
}
class N95Mask implements Mask{
    @Override
    public void wear() {
        System.out.println("wear the mask");
    }
}

//具体工厂，工厂只是用来生产的
class SuperFactory implements AbstractFactory{

    @Override
    public Phone createPhone(String param) {
        return new IPhone();
    }

    @Override
    public Mask createMasks(String param) {
        return new N95Mask();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory = new SuperFactory();
        Phone phone = factory.createPhone("");
        phone.print();
    }

}
