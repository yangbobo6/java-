package annotation;

import java.lang.annotation.*;
import java.util.Arrays;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocumentA {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocumentB {

}


@DocumentA
class A{}

@DocumentB
public class DocumentDemo extends A{
    public static void main(String[] args) {
        Class<?> clazz = DocumentDemo.class;
        //根据指定注解类型获取该注解
        DocumentA documentA = clazz.getAnnotation(DocumentA.class);
        System.out.println("A: "+documentA);
        System.out.println(documentA);

        //获取该元素上的所有注解，包含从父类继承
        Annotation[] an = clazz.getAnnotations();
        System.out.println("an: "+ Arrays.toString(an));

        //获取该元素上的所有注解，但不包含继承！
        Annotation[] an2=clazz.getDeclaredAnnotations();
        System.out.println("an2:"+ Arrays.toString(an2));

        //判断注解DocumentA是否在该元素上
        boolean b=clazz.isAnnotationPresent(DocumentA.class);
        System.out.println("b:"+b);

    }
}
