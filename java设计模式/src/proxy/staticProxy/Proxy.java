package proxy.staticProxy;

/**
 * @author zhangsan
 * @date 2021-04-18 10:37
 */
public class Proxy implements Rent{
    private Host host;
    //private Host host1 = new Host();
    public Proxy(){};

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        //host1.rent();
        host.rent();
        seeHouse();
        fee();
    }

    private void fee() {
        System.out.println("中介费");
    }

    private void seeHouse() {
        System.out.println("看房子");
    }


    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
}
