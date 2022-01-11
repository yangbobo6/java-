package strategy;

import java.util.Stack;

/**    1/11
 * 策略模式
 * 洗衣服  -快洗  -洗大件  -慢洗  3种策略
 *
 */
abstract class Strategy{
    public abstract void wash();
}

class FastWash extends Strategy{
    @Override
    public void wash() {
        System.out.println("快洗模式");
    }
}
class SlowWash extends Strategy{

    @Override
    public void wash() {
        System.out.println("慢洗模式");
    }
}

class BigWash extends Strategy{

    @Override
    public void wash() {
        System.out.println("洗大衣服");
    }
}
class Client {
    //持有抽象策略角色的引用
    private Strategy strategy;


    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public void washCloth(){
        strategy.wash();
    }

}

public class StrategyPattern {
    public static void main(String[] args) {
        Client client = new Client();
        client.setStrategy(new FastWash());
        client.washCloth();
    }
}
