package proxy.dynamic;

import proxy.staticProxy.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;
    //set方法
    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成代理类，重点是第二个参数，获取要代理的抽象角色！之前都是一个角色，现在可以代理一类角色
    public Object getProxy(){
        /**
         * loader :类加载器，用于加载代理对象。
         * interfaces : 被代理类实现的一些接口；
         * h : 实现了 InvocationHandler 接口的对象；
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy   动态生成的代理类
     * @param method  与代理类对象调用的方法相对应
     * @param args    当前 method 方法的参数
     * @return
     * @throws Throwable
     *
     *通过Proxy 类的 newProxyInstance() 创建的代理对象在调用方法的时候，
     * 实际会调用到实现InvocationHandler 接口的类的 invoke()方法。
     * 你可以在 invoke() 方法中自定义处理逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();

        //核心：本质利用反射实现！
        Object result = method.invoke(rent, args);

        fare();
        return result;
    }

    public void fare(){
        System.out.println("收中介费");
    }

    public void seeHouse(){
        System.out.println("看房");
    }
}
