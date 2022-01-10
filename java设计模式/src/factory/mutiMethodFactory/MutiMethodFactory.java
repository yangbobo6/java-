package factory.mutiMethodFactory;
interface Restaurant{
    void cook();
}

class Meet implements Restaurant{
    String param;
    public Meet(String param){
        this.param = param;
    }

    @Override
    public void cook() {
        System.out.println("肉"+param);
    }
}

class Fish implements Restaurant{

    @Override
    public void cook() {
        System.out.println("🐟");
    }
}

class FactoryClass{
    //public static Meet meet = new Meet(String param);
    public static Meet getMeet(String param){
        return new Meet(param);
    }

    public static Fish getFish(){
        return new Fish();
    }
    public static Fish fish = new Fish();
}

public class MutiMethodFactory {
    public static void main(String[] args) {
        Restaurant meet = FactoryClass.getMeet("1");
        meet.cook();

        Restaurant fish = FactoryClass.getFish();
        fish.cook();
        Restaurant fish1 = FactoryClass.fish;
        fish1.cook();
    }
}
