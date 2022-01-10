package proxy.proxy2;

/**
 * @author zhangsan
 * @date 2021-04-18 11:09
 */
public class main {
    public static void main(String[] args) {
        Service service = new Service();
        service.add();
        System.out.println("--------------");

        ServiceProxy serviceProxy = new ServiceProxy();
        serviceProxy.setService(service);
        serviceProxy.add();
    }
}
