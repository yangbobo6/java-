package factory.reflectAbstrFactory;

import java.util.Properties;

/**
 * 抽象工厂类
 * 用 **反射** 功能实现
 *
 */

//抽象产品类的公共接口
abstract class Product{
    public abstract void show();
}

//具体产品A
class ProductA extends Product{
    @Override
    public void show() {
        System.out.println("生产出了产品A");
    }
}

//具体产品B
class ProductB extends Product{

    @Override
    public void show() {
        System.out.println("生产出了产品B");
    }
}
//创建工厂类
class Factory{
    //定义方法 ： 通过反射动态创建产品类
    public static Product getInstance(String ClassName){
        Product concreteProduct  = null;
        try{
            // 1. 根据 传入的产品类名 获取 产品类类型的Class对象
            Class product_Class = Class.forName(ClassName);
            concreteProduct = (Product) product_Class.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return concreteProduct;
    }

}
//外界通过调用工厂类的静态方法（反射原理），传入不同参数从而创建不同具体产品类的实例
public class reflectFactory {
    public static void main(String[] args) {
        // 1. 通过调用工厂类的静态方法（反射原理），从而动态创建产品类实例
        // 需传入完整的类名 & 包名
        Product concreteProduct = Factory.getInstance("factory.reflectAbstrFactory.ProductB");

        //调用该产品类对象的方法，从而生产产品
        concreteProduct.show();

        //1. 读取属性配置文件

    }

}
