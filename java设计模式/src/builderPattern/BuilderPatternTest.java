package builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/01/14 21:22
 * 建造者模式
 * Director-->Builder-->ConcreteBuilder-->Product
 * 例子：
 */

//电脑城老板委派任务给装机人员（Director）
class Director{
    //指挥装机人员组装电脑
    public void Construct(Builder builder){
        builder.BuilderCPU();
        builder.BuildMainBoard();
        builder.BuildHD();
    }
}

//定义builder，组装电脑的过程，声明抽象方法，具体由子类实现
abstract class Builder{
    //第一步：装CPU
    //声明为抽象方法，具体由子类实现
    public abstract void BuilderCPU();
    //装主板，声明抽象方法，具体由子类实现
    public abstract void BuildMainBoard();
    //装硬盘，声明抽象方法，具体由子类实现
    public abstract void BuildHD();
    //返回产品的方法：获得组装好的电脑
    public abstract Computer GetComputer();
}
//创建具体的建造者（ConcreteBuilder）:装机人员
class ConcreteBuilder extends Builder{
    //创建产品实例
    Computer computer = new Computer();
    //组装产品
    @Override
    public void BuilderCPU() {
        computer.Add("组装CPU");
    }

    @Override
    public void BuildMainBoard() {
        computer.Add("组装主板");
    }

    @Override
    public void BuildHD() {
        computer.Add("组装磁盘");
    }

    @Override
    public Computer GetComputer() {
        return computer;
    }
}

//产品实例（Product）
class Computer{
    //电脑组件的集合
    private List<String> parts = new ArrayList<>();
    //用于将组建撞到电脑里面
    public void Add(String part){
        parts.add(part);
    }
    public void show(){
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件"+parts.get(i)+"装好了");
        }
        System.out.println("电脑组装完成，请验收");
    }
}

public class BuilderPatternTest {
    public static void main(String[] args) {
        //逛了很久，发现了电脑店，
        //找老板和装机人员
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        //沟通之后，老板让装机人员去装电脑
        director.Construct(builder);
        //装完后，组装人员搬来组装好的电脑
        Computer computer = builder.GetComputer();
        //组装人员展示电脑给小成看
        computer.show();
    }
}
