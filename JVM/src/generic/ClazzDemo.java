package generic;

public class ClazzDemo {
    public static void main(String[] args) {
        //没有泛型
        Class clazz = int.class;

        //带泛型的Class对象
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class;

        //没有泛型的约束,可以随意赋值
        clazz = double.class;

        //integerClass = double.class;  有泛型约束，编译无法通过


        //编译无法通过
        //Class<Number> numberClass=Integer.class;

        //使用通配符来解决问题
        Class<?> intClass = int.class;
        intClass = double.class;

        //编译通过！
        Class<? extends Number> clazz2 = Integer.class;
        //赋予其他类型
        clazz2 = double.class;
        clazz2 = Number.class;


    }
}
