package factory.abstractFactory;
//抽象工厂模式

/**
 * 电子产品    -->抽象
 * phone 产品  pad产品  -->抽象
 * iphone 产品  ipad产品  miPhone产品  miPad产品
 *
 * 工厂   -->抽象
 * Apple工厂   Mi工厂
 */


abstract class ElectricProduct{
    public abstract void show();
}


//容器产品抽象类
abstract class PhoneProduct extends ElectricProduct{
    @Override
    public abstract void show();
}
//模具产品抽象类
abstract class PadProduct extends ElectricProduct{
    @Override
    public abstract void show();
}
//容器产品A类
class Iphone extends PhoneProduct{

    @Override
    public void show() {
        System.out.println("生产了Iphone");
    }
}

class Mi10 extends PhoneProduct{
    @Override
    public void show() {
        System.out.println("生产小米手机10");
    }
}

class Ipad extends PadProduct{

    @Override
    public void show() {
        System.out.println("生产Ipad");
    }
}

class MiPad extends PadProduct{

    @Override
    public void show() {
        System.out.println("生产平板Pad");
    }
}

abstract class Factory{
    public abstract ElectricProduct ManufactureApple();
    public abstract ElectricProduct ManufactureMi();
}
//创建工厂A - 生产模具+容器产品
class AppleFactory extends Factory{
    @Override
    public ElectricProduct ManufactureApple() {
        return new Iphone();
    }

    @Override
    public ElectricProduct ManufactureMi() {
        return new Ipad();
    }
}

//创建工厂B
class MiFactory extends Factory{
    @Override
    public ElectricProduct ManufactureApple() {
        return new Ipad();
    }

    @Override
    public ElectricProduct ManufactureMi() {
        return new MiPad();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        Factory factory = new AppleFactory();
        factory.ManufactureApple().show();

        Factory miFactory = new MiFactory();
        miFactory.ManufactureMi().show();

    }

}
