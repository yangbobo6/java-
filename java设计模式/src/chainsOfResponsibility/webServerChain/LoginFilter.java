package chainsOfResponsibility.webServerChain;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-11:35
 * @Description:
 */
public class LoginFilter implements Filter{
    @Override
    public void initial() {
        System.out.println("filter初始化");
    }

    @Override
    public void doFilter(int a, int b, FilterChain chain) {
        System.out.println("调用login过滤器");
        chain.doFilter(a,b);
    }

    @Override
    public void destroy() {
        System.out.println("filter被销毁");
    }
}
