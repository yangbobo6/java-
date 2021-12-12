package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("reflect.Student");
        //获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
        // 否则抛NoSuchFieldException
        Field field = clazz.getField("age");
        System.out.println("field:"+field);
        System.out.println("===========================");

        Field[] fields = clazz.getFields();
        for (Field field1:fields
             ) {
            System.out.println(field1+"------------"+field1.getDeclaringClass());
        }

        System.out.println("----------------------------");

        Student stu = (Student)clazz.getDeclaredConstructor().newInstance();
        Field ageFiled = clazz.getField("age");
        System.out.println(ageFiled);
        ageFiled.set(stu,18);
        Field nameFiled = clazz.getField("name");
        nameFiled.set(stu,"yangbo");

        //只获取当前字段，不获取父类字段
        Field descFiled = clazz.getDeclaredField("desc");
        descFiled.set(stu,"i am yangbo");
        Field scoreFiled = clazz.getDeclaredField("score");
        //将private的权限
        scoreFiled.setAccessible(true);
        scoreFiled.set(stu,18);
        System.out.println(stu.toString());
        scoreFiled.get(stu);

        Student stu1 = (Student)clazz.getDeclaredConstructor().newInstance();


    }
}
