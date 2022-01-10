package proxy.staticProxy;

/**
 * @author zhangsan
 * @date 2021-04-18 10:27
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }

}
