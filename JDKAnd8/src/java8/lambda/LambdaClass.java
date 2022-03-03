package java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-03-14:36
 * @Description:
 *
 *
 * 函数式接口   当接口中只有一个方法的时候  称为函数式接口
 * 四大函数式接口  Consumer  Function  Predicate  Supplier
 *
 * lambda  可以简化函数式接口
 */
@FunctionalInterface
interface LambdaInterface{
    void f();
}
//使用
public class LambdaClass {
    public static void forEg(){
        lambdaInterfaceDemo(()-> System.out.println("自定义函数接口"));
    }

    //函数式接口参数
    static void lambdaInterfaceDemo(LambdaInterface i){
        System.out.println(i);
    }

    void lambdaFor(){
        List<String > strings = Arrays.asList("1","2","23");

        //常规写法
        for (String s:strings
             ) {
            System.out.println(s);
        }
        //lambda foreach
        strings.forEach((s)-> System.out.println(s));
        //or
        strings.forEach(System.out::println);


    }

}
