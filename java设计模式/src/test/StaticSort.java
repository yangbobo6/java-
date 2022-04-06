package test;

/**
 * @Author: yangbo
 * @Date: 2022-04-06-15:07
 * @Description:
 */
public class StaticSort {
    static {
        System.out.println("静态代码块");
    }
    public static int i = 1;  //类变量

    
    {
        System.out.println("代码块");
    }

    public int j = 0;           //成员变量
    public StaticSort(){
        System.out.println("构造方法块");
    }
    
    public static void main(String[] args) {
        System.out.println("main方法");
        StaticSort staticSort = new StaticSort();
        
    }
}
