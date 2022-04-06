package proxy.dynamic2;

/**
 * @Author: yangbo
 * @Date: 2022-04-05-12:08
 * @Description:
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }
}
