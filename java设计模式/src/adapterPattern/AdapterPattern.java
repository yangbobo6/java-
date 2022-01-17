package adapterPattern;

//这是源类Adaptee没有的方法
interface TargetChina{
    //国内手机充电器只能220平头充电
    public void request_220v();
}
//创建源类
class EuroCharge_110v{  //欧洲充电插头
    public void specificRequest(){

    }
}
//适配器Adapter继承自Adaptee，同时又实现了目标(Target)接口。
class AdapterGongNiu implements TargetChina{

    //目标接口要求调用Request()这个方法名，但源类Adaptee没有方法Request()
    //因此适配器补充上这个方法名
    //但实际上Request()只是调用源类Adaptee的SpecificRequest()方法的内容
    //所以适配器只是将SpecificRequest()方法作了一层封装，封装成Target可以调用的Request()而已
    private EuroCharge_110v euroCharge_110v;
    public AdapterGongNiu(EuroCharge_110v euroCharge_110v){
        this.euroCharge_110v = euroCharge_110v;
    }

    @Override
    public void request_220v() {
        this.euroCharge_110v.specificRequest();
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        TargetChina mAdapter = new AdapterGongNiu(new EuroCharge_110v());
        mAdapter.request_220v();
    }
}
