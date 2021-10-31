package com.designPattern.FactoryPattern;

abstract class Product{
    public abstract void show();
}

class ProductShoes extends Product {
    @Override
    public void show() {
        System.out.println("生产鞋子👠");
    }
}
class ProductClothes extends Product{
    @Override
    public void show() {
        System.out.println("生产大衣🧥");
    }
}

abstract class Factory{
    public abstract Product manufacture();
}

class FactoryShoes extends Factory{

    @Override
    public Product manufacture() {
        return new ProductShoes();
    }
}
class FactoryCloths extends Factory{

    @Override
    public Product manufacture() {
        return new ProductClothes();
    }
}

public class FactoryMethod2 {
    public static void main(String[] args) {
        FactoryCloths factoryCloths = new FactoryCloths();
        factoryCloths.manufacture().show();


    }

}
