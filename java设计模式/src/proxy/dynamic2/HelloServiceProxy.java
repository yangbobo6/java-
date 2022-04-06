package proxy.dynamic2;

import java.lang.reflect.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: yangbo
 * @Date: 2022-04-05-12:10
 * @Description:   代理类  在HelloService输出前后  输出内容   类似日志，事务处理  AOP思想
 */
public class HelloServiceProxy implements InvocationHandler {
    public Object target;

    /**
     * 
     * @param target  真实对象
     * @param interfaces
     * @return    代理对象
     */
    public Object bind(Object target, Class[] interfaces) {
        this.target = target;
        //取得代理对象   
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);  
    }  

    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理-----");
        Object result = null;
        //反射方法前调用
        System.out.println("调用前");
        result = method.invoke(target,args);
        System.out.println("调用后");
        
        return result;
    }
}
