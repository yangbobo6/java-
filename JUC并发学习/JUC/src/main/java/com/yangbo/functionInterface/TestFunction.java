package com.yangbo.functionInterface;

interface MyInterface{
    void test();
    String toString();
}

public class TestFunction {
    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        TestFunction function = new TestFunction();
        function.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("myTest");
            }
        });


        System.out.println("=====================");
        //改用lamdba表达式写
        function.myTest(()->{
            System.out.println("myTest1");
        });
        System.out.println("=====================");


        //Lamdba表达式的写法就是MyInterface的匿名实现类
        MyInterface myInterface = ()->{
            System.out.println("myTest2");
        };
        myInterface.test();
        System.out.println(myInterface);
        System.out.println(myInterface.getClass().getSuperclass());
    }

}
