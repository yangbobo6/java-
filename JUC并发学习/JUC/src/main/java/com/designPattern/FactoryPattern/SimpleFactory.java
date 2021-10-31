package com.designPattern.FactoryPattern;
//简单的工厂模式

//做饭接口
interface Restaurant{
    public void cook();
}

class Meet implements Restaurant{
    @Override
    public void cook() {
        System.out.println("小炒肉");
    }
}

class Fish implements Restaurant{
    @Override
    public void cook() {
        System.out.println("🐟肉");
    }
}

class Duck implements Restaurant{
    @Override
    public void cook() {
        System.out.println("北京考🦆");
    }
}

class Waiter {
    public static final int MENU_MEET = 1;  //肉
    public static final int MENU_FISH = 2;  //肉
    public static final int MENU_DUCK = 3;  //肉

    public static Restaurant getMenu(int menuType){
        switch (menuType){
            case MENU_MEET:
                return new Meet();
            case MENU_FISH:
                return new Fish();
            default:
                return new Duck();
        }
    }

}

public class SimpleFactory {
    public static void main(String[] args) {
//        Restaurant restaurant = new Fish();
//        restaurant.cook();
        Restaurant restaurant = Waiter.getMenu(Waiter.MENU_DUCK);
        restaurant.cook();
    }
}
