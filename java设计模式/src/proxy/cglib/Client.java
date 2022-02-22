package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: yangbo
 * @Date: 2022-02-22-15:47
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws Exception{
        ProxyInterceptor proxyInterceptor = new ProxyInterceptor(new Host1());
        Host1 host1 = (Host1) proxyInterceptor.createProxy();
        host1.rent();
    }
}
