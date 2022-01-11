package factory.factoryMethod;
abstract class Factory{
    public abstract Product Manufacture();
}
abstract class Product{
    public abstract void Show();
}

class Product1 extends Product{
    @Override
    public void Show() {
        System.out.println("产品1");
    }
}

class Product2 extends Product{
    @Override
    public void Show() {
        System.out.println("产品2");
    }
}

class FactoryA extends Factory{

    @Override
    public Product Manufacture() {
        return new Product1();
    }
}

class FactoryB extends Factory{

    @Override
    public Product Manufacture() {
        return new Product2();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.Manufacture().Show();

        FactoryB factoryB = new FactoryB();
        factoryB.Manufacture().Show();
    }


}
