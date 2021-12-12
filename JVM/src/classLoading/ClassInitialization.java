package classLoading;
import java.util.*;
class Initable{
    //编译期间静态常量
    static final int staticFinal = 47;
    //非编译期间 静态常量
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static{
        System.out.println("Intializing Initable");
    }
}

class Initable2{
    //静态成员变量   非编译期间的变量
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    //静态成员变量
    static int staticNonFinal = 47;
    static {
        System.out.println("Initializing Intiable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception{
        //字面常量获取方式  获取Class对象
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        //不触发  类初始化
        System.out.println(Initable.staticFinal);

        System.out.println("------1-------");

        //会触发 类初始化
        System.out.println(Initable.staticFinal2);
        System.out.println("----2------");
        //会触发 类初始化
        System.out.println(Initable2.staticNonFinal);

        System.out.println("----3------");
        //forName 方法获取Class对象
        Class initable3 = Class.forName("classLoading.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }

}
