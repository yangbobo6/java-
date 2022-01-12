package chainsOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器  是使用责任链模式
 * 模拟简单的责任链实现  2021/1/11
 * 人-->身高过滤器-->学历过滤器-->服务器
 * 出处：
 * https://www.cnblogs.com/father-of-little-pig/p/11488898.html
 */

//请求
class MyRequest{
    String str;
}
//响应
class MyResponse{
    String str;
}

//模拟实现过滤器
interface MyFilter{
    void doFilter(MyRequest myRequest,MyResponse myResponse);
}
// 相当于
class MyFilterChain implements MyFilter{

    List<MyFilter> list = new ArrayList<MyFilter>();
    public MyFilterChain add(MyFilter myFilter){
        list.add(myFilter);
        return this;
    }

    @Override
    public void doFilter(MyRequest myRequest, MyResponse myResponse) {
        for (MyFilter f:list
             ) {
            f.doFilter(myRequest,myResponse);
            System.out.println(myRequest.str+"----"+myResponse.str);

        }
    }
}

//身高过滤器
class HeightFilter implements MyFilter{

    @Override
    public void doFilter(MyRequest myRequest, MyResponse myResponse) {
        myRequest.str = myRequest.str.replace("170","个子有点矮");
        myResponse.str += "【妹子挑剔，需要身高】";
    }
}
//教育过滤器
class EducationFilter implements MyFilter{

    @Override
    public void doFilter(MyRequest myRequest, MyResponse myResponse) {
        myRequest.str = myRequest.str.replace("学历大专", "学历不高");
        myResponse.str = "【妹子挑剔，需要学历】";
    }
}

public class MyFilterChainTest {
    public static void main(String[] args) {
        MyRequest myRequest = new MyRequest();
        myRequest.str = "张三身高170，学历大专，求妹子认识";
        System.out.println("request:"+myRequest.str);

        MyResponse myResponse = new MyResponse();
        myResponse.str = "";
        //定义责任链 ***
        MyFilterChain chain = new MyFilterChain();
        //将 过滤 信息加入
        chain.add(new HeightFilter()).add(new EducationFilter());
        //触发责任链
        chain.doFilter(myRequest,myResponse);
        System.out.println("response:"+myResponse.str);
    }

}
