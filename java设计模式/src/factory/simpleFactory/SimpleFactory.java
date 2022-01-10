package factory.simpleFactory;
interface Restaurant{
    public void cook();
}
class Duck implements Restaurant{

    @Override
    public void cook() {
        System.out.println("北京烤鸭");
        return ;
    }
}

class Fish implements Restaurant{

    @Override
    public void cook() {
        System.out.println("鱼肉");
    }
}

class Meet implements Restaurant{

    @Override
    public void cook() {
        System.out.println("红烧肉");
    }
}

class Waiter{
    public static final int MENU_MEET = 1;
    public static final int MENU_FISH = 2;
    public static final int MENU_DUCK = 3;

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
//        Restaurant duck = new Duck();
//        duck.cook();
        //简单工厂模式  改造
        Restaurant restaurant = Waiter.getMenu(1);
        restaurant.cook();

    }
}
