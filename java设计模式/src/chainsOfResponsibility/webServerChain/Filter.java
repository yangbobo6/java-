package chainsOfResponsibility.webServerChain;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-11:31
 * @Description:
 */
public interface Filter {
    void initial();
    void doFilter(int a,int b,FilterChain chain);
    void destroy();
}
