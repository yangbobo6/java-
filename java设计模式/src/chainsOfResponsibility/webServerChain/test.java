package chainsOfResponsibility.webServerChain;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-11:37
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        int a = 25;
        int b = 26;
        AbstractRequestHandler handler = new AbstractRequestHandler();
        handler.doFilter(a,b);
    }
}
