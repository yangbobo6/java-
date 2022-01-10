package singleton;
//饿汉写法
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1(){
    }

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    //方法没有加同步块，所以它效率高  但是在多线程情况会可能造成创建多个实例
    public static Singleton1 getInstance(){
        return singleton1;
    }

}
