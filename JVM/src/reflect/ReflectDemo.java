package reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class ReflectDemo implements Serializable {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = null;
        //获取class对象的引用
        clazz = Class.forName("reflect.User");

        //第一种方法，实例化 默认 构造方法，User必须是无参构造函数，否则抛异常
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        user.setAge(20);
        user.setName("YangBo");
        System.out.println(user);

        System.out.println("---------------------|");

        //获取带String参数的public构造函数
        Constructor cs1 = clazz.getConstructor(String.class);
        //创建user
        User user1 = (User) cs1.newInstance("tanjing");
        user1.setAge(22);
        System.out.println(user1.toString());

        System.out.println("------------------------");

        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor cs2 = clazz.getDeclaredConstructor(int.class,String.class);
        //由于是private必须设置可访问
        cs2.setAccessible(true);
        //创建user对象
        User user2 = (User) cs2.newInstance(22,"tantan");
        System.out.println(user2.toString());

        System.out.println("------------------------------");

        //获取所有构造函数包含private
        Constructor<?> cons[] = clazz.getDeclaredConstructors();
        //查看每个构造方法所需要的参数
        for (int i = 0; i < cons.length; i++) {
            //获取构造参数的  参数类型
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("构造函数--【"+i+"】"+cons[i].toString());
            System.out.print("参数类型 -- 【"+i+"】:(");
            for (int j = 0; j < clazzs.length; j++) {
                if(j==clazzs.length-1){
                    System.out.print(clazzs[j].getName());
                }else {
                    System.out.print(clazzs[j].getName()+",");
                }
                System.out.println(")");
            }
        }

    }

}
