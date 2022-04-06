package proxy.dynamic2;

/**
 * @Author: yangbo
 * @Date: 2022-04-05-13:39
 * @Description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        //代理初始化
        HelloServiceProxy proxy = new HelloServiceProxy();
        //真是对象
        HelloService service = new HelloServiceImpl();
        
        service = (HelloService)proxy.bind(service,new Class[]{HelloService.class});
        service.sayHello("yangbo");
        
    }
}
