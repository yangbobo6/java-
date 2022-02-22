package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: yangbo
 * @Date: 2022-02-22-15:40
 * @Description:  cglib 动态代理
 */
public class ProxyInterceptor implements MethodInterceptor {

    private Object target;
    public ProxyInterceptor(Object target){
        this.target = target;
    }

    //创建代理对象
    public Object createProxy(){
        //创建enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用方法前");
        method.invoke(target,objects);
        System.out.println("调用方法后");
        return null;
    }
}
