package proxy.staticProxy;

/**
 * @author zhangsan
 * @date 2021-04-18 10:27
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东出租的房子");
    }
}
