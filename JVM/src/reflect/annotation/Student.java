package reflect.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: yangbo
 * @Date: 2022-02-20-21:19
 * @Description:
 */
@TableBo("db_student")
public class Student {

    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("reflect.annotation.Student");
        Student student = (Student)clazz.getConstructor().newInstance();
        clazz.getDeclaredMethod("setAge", int.class).invoke(student, 10);
        System.out.println(student.getAge());
        System.out.println(student.age);
        //通过反射获取注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a:annotations
             ) {
            System.out.println(a);
        }

        //获取注解的value
        TableBo tableBo = (TableBo)clazz.getAnnotation(TableBo.class);
        String value = tableBo.value();
        System.out.println(value);

        //获得类 指定的注解
        Field name = clazz.getDeclaredField("name");
        FiledBo annotation = name.getAnnotation(FiledBo.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());
    }



    @FiledBo(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FiledBo(columnName = "db_name",type = "varchar",length = 200)
    private String name;
    @FiledBo(columnName = "db_age",type = "int",length = 3)
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
