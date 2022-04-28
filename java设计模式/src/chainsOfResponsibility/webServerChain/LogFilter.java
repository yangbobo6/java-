package chainsOfResponsibility.webServerChain;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-11:38
 * @Description:
 */
public class LogFilter implements Filter {


    @Override
    public void initial() {
        
    }

    @Override
    public void doFilter(int a, int b, FilterChain chain) {
        System.out.println(a+b);
        System.out.println("调用log过滤器");
        chain.doFilter(a,b);
    }

    @Override
    public void destroy() {

    }
}
