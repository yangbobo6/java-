import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
    public Student(){
        System.out.println("无参构造创建");
    }
    public void setName1(){
        System.out.println("调用无参方法：setName1()");
    }
    public void setName2(String str){
        System.out.println("调用有参setName(String str)"+str);
    }

}
public class Test {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Student> studentClass = Student.class;

        Student student = studentClass.newInstance();

        Method setName1 = studentClass.getMethod("setName1");
        System.out.println(setName1);

        setName1.invoke(student);
    }
}
