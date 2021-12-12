package reflect.reflectMethod;

import java.lang.reflect.Method;

public class reflectMethod {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("reflect.reflectMethod.Circle");
        //根据参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw",int.class,String.class);
        System.out.println(method);

        //获取所有public的方法
        Method[] methods = clazz.getMethods();
        for (Method m:methods
             ) {
            System.out.println(m);
        }
        System.out.println("========================");
        //获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method drawCircle = clazz.getDeclaredMethod("drawCircle");
        Method[] declaredMethods = clazz.getDeclaredMethods();

        System.out.println("-------------------------");
        Circle circle = (Circle)clazz.getDeclaredConstructor().newInstance();
        //公有方法的调用
        Method draw = clazz.getMethod("draw", int.class, String.class);
        draw.invoke(circle,15,"圈圈");
        //私有无参方法调用
        Method drawCircle1 = clazz.getDeclaredMethod("drawCircle");
        drawCircle1.setAccessible(true);
        drawCircle1.invoke(circle);

        //对有返回值的进行操作
        Method method2 = clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method2.invoke(circle);
        System.out.println(count);


    }
}

class Shape{
    public void draw(){
        System.out.println("draw");
    }
    public void draw(int count,String name){
        System.out.println("draw"+name+",count="+count);
    }
}

class Circle extends Shape{
    private void drawCircle(){
        System.out.println("drawCircle");
    }
    public int getAllCount(){
        return 100;
    }
}
