package chainsOfResponsibility.webServerChain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-11:34
 * @Description:  设计模式
 */
public class AbstractRequestHandler implements FilterChain{

    Deque<Filter> filters = new ArrayDeque<>();
    Filter filter1;
    private int index = 0;
    
    public AbstractRequestHandler(){
        filter1 = new LoginFilter();
        filters.add(filter1);
        filters.add(new LogFilter());
    }
    
    @Override
    public void doFilter(int a, int b) {
        if(index<filters.size()){
            System.out.println(index+"---"+filters.size());
            index++;
            filters.getFirst().doFilter(a,b,this);
        }else {
            System.out.println("小谭热爱健身，结束");
        }
    }
}
