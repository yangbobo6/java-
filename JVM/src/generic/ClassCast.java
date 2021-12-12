package generic;

interface Animals{}

class Dog implements Animals{

}

public class ClassCast {
    public void cast(){
        Animals animals = new Dog();
        //强制转换
        Dog dog = (Dog) animals;
        //相当于
        Class<Dog> dogType = Dog.class;
        Dog dog1 = dogType.cast(animals);
    }
    public void cast2(Object obj){
        if(obj instanceof Animals){
            Animals animals = (Animals) obj;
        }
    }
}
