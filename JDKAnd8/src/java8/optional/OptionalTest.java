package java8.optional;

import java.util.Optional;

/**
 * @Author: yangbo
 * @Date: 2022-03-03-16:48
 * @Description:   使用 Optional 解决 NPE（java.lang.NullPointerException）问题，
 * 它就是为 NPE 而生的，其中可以包含空值或非空值。
 */
//动物类  包含Dog对象
class Zoo {

    private Dog dog;

    public Dog getDog() {
        return dog;
    }
}
//dog类
class Dog {
    private int age;

    public int getAge() {
        return age;
    }
}




public class OptionalTest {


    public static void main(String[] args) {
        //传统解决方法
        Zoo zoo = new Zoo();
        if(zoo != null){
            Dog dog = zoo.getDog();
            if(dog != null){
                int age = dog.getAge();
                System.out.println(age);
            }
        }

        //optional实现
        Optional.ofNullable(zoo)      //判断zoo是否为空
                .map(o->o.getDog())   //获取dog
                .map(dog -> dog.getAge())  //获取dog的age
                .ifPresent(age-> System.out.println(age));
    }
}
