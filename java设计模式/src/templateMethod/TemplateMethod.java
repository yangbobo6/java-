package templateMethod;
/**
 * 2021/1/14 模板方法设计模式
 * 用炒菜的例子来学习模板方法设计模式
 *
 */
abstract class AbsCook{
    //模板方法，用来控制炒菜的流程 （炒菜的流程是一样的-复用）
    //申明为final，不希望子类覆盖这个方法，防止更改流程的执行顺序
    final void cookProcess(){
        //第一步  倒油
        this.pourOil();
        //第二步  热油
        this.heatOil();
        //倒蔬菜
        this.pourVegetable();
        //倒调味料
        this.pourSauce();
        //翻炒
        this.fry();

    }

    void pourOil(){
        System.out.println("倒油");
    }
    void heatOil(){
        System.out.println("热油");
    }
    //第三步：倒蔬菜是不一样的（一个下包菜，一个是下菜心）
    //所以声明为抽象方法，具体由子类实现
    abstract void pourVegetable();
    abstract void pourSauce();

    void fry(){
        System.out.println("翻炒");
    }
}

//创建具体模板（Concrete Class）,即”手撕包菜“和”蒜蓉炒菜心“的具体步骤
class ConcreteBaocai extends AbsCook{

    @Override
    void pourVegetable() {
        System.out.println("放入手撕包菜");
    }

    @Override
    void pourSauce() {
        System.out.println("放入料包 辣椒");
    }
}
class ConcreteCaixin extends AbsCook{

    @Override
    void pourVegetable() {
        System.out.println("放入菜心");
    }

    @Override
    void pourSauce() {
        System.out.println("放入蒜蓉");
    }
}
public class TemplateMethod {
    public static void main(String[] args) {
        //抄-手撕包菜
        AbsCook baocai = new ConcreteBaocai();
        baocai.cookProcess();
        System.out.println("===========");

        ConcreteCaixin caixin = new ConcreteCaixin();
        caixin.cookProcess();
    }
}
