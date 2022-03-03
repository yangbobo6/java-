package java8.lambda;

/**
 * @Author: yangbo
 * @Date: 2022-03-03-14:56
 * @Description:  Java 8 允许使用 :: 关键字来传递方法或者构造函数引用，无论如何，表达式返回的类型必须是 functional-interface。
 */

class LambdaClassSuper{
    LambdaInterface sf(){
        return null;
    }
}

public class LambdaClass1 extends LambdaClassSuper{
    public static LambdaInterface staticF(){
        return null;
    }

    public LambdaInterface f(){
        return null;
    }

    void show(){
        //1.调用静态函数，返回类型必须是functional-interface
        LambdaInterface lambdaClass = LambdaClass1::staticF;

        //2.实例方法的调用
        LambdaClass1 lambdaClass1 = new LambdaClass1();
        LambdaInterface lambdaInterface = lambdaClass1::f;

        //3.超类上的方法调用
        LambdaInterface superf = super::sf;

        //4. 构造方法调用
        LambdaInterface tt = LambdaClassSuper::new;

    }


}
