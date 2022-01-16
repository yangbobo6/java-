package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式   发布订阅模式
 * 1.可以是一对多 模式
 * 2.当1个对象的状态发生改变时，所有依赖于它的对象都将得到通知 & 自动更新对应操作。
 * 顾客（被观察者）--> 服务员 --> 消费者（观察者）
 * 被观察者 （Observable） 通过 订阅（Subscribe） 按顺序发送事件 给观察者 （Observer）， 观察者（Observer） 按顺序接收事件 & 作出对应的响应动作。
 */

//主题（发布者、被观察者）
interface Subject{
    //注册观察者
    void registerObserver(Observer observer);
    //移除观察者
    void removeObserver(Observer observer);
    //通知观察者
    void notifyObserver();
}

//观察者
interface Observer{
    void update();
}
//公告牌用于显示公共接口
interface DisplayElement{
    void display();
}

class WeatherData implements Subject{

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float presses;
    private List<Float> forecastTemperature;  //未来几天的温度

    public WeatherData(){
        this.observers = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObserver() {
        for (Observer observer:observers
             ) {
            notifyObserver();
        }
    }
}

public class ObservationPattern {

}
