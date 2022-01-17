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

//天气预报  被观察者
class WeatherData implements Subject{

    private List<Observer> observers;
    private float temperature;  //温度
    private float humidity;     //湿度
    private float presses;      //压力
    private List<Float> forecastTemperature;  //未来几天的温度

    //天气数据 构造方法
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
            observer.update();
        }
    }
    //测量改变
    public void measurementsChanged(){
        notifyObserver();
    }
    //set方法  设置天气状态
    public void setMeasurements(float temperature,float humidity,
                                float presses,List<Float> forecastTemperature ){
        this.temperature = temperature;
        this.humidity = humidity;
        this.presses = presses;
        this.forecastTemperature = forecastTemperature;
        measurementsChanged();
    }
    //get方法
    public float getTemperature(){
        return temperature;
    }
    public float getHumidity(){
        return humidity;
    }
    public float getPresses(){
        return presses;
    }
    public List<Float> getForecastTemperature(){
        return forecastTemperature;
    }

}
//显示当前天气的公告牌
class CurrentConditionDisplay implements Observer,DisplayElement{
    private WeatherData weatherData;
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    //被观察  交给观察者
    @Override
    public void update() {
        this.temperature = this.weatherData.getTemperature();
        this.humidity = this.weatherData.getHumidity();
        this.pressure = this.weatherData.getPresses();
        display();
    }

    @Override
    public void display() {
        System.out.println("当前温度为："+this.temperature+"°C");
        System.out.println("当前湿度为："+this.humidity);
        System.out.println("当前温度为："+this.pressure);
    }
}

//显示未来天气的公告牌
class ForecastDisplay implements Observer,DisplayElement{
    private WeatherData weatherData;
    private List<Float> forecastTemperatures;  //未来几天的温度

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.forecastTemperatures = this.weatherData.getForecastTemperature();
        display();
    }

    @Override
    public void display() {
        System.out.println("未来几天的温度");
        int count = forecastTemperatures.size();
        for (int i = 0; i < count; i++) {
            System.out.println("第"+i+"天"+forecastTemperatures.get(i)+"°C");
        }
    }
}



public class ObservationPattern {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        List<Float> forecastTemperature = new ArrayList<>();
        forecastTemperature.add(22f);
        forecastTemperature.add(-1f);
        forecastTemperature.add(9f);
        forecastTemperature.add(23f);
        forecastTemperature.add(27f);
        forecastTemperature.add(30f);
        forecastTemperature.add(10f);
        weatherData.setMeasurements(22f,0.8f,1.2f,forecastTemperature);
    }
}
