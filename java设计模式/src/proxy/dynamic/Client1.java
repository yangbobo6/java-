package proxy.dynamic;

import proxy.proxy2.Crud;
import proxy.proxy2.Service;

/**
 * @Author: yangbo
 * @Date: 2022-02-22-12:23
 * @Description:
 */
public class Client1 {
    public static void main(String[] args) {
        Service service = new Service();

        ProxyInvocationHandler1 proxyInvocationHandler1 = new ProxyInvocationHandler1();
        proxyInvocationHandler1.setTarget(service);

        //动态创建代理类
        Crud proxy = (Crud) proxyInvocationHandler1.getProxy();
        proxy.add();

    }

}
