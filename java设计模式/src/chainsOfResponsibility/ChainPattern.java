package chainsOfResponsibility;
/**
 * 责任链模式
 * 商品优惠券满减 ： 第一次购买-10-->满200减20 --> 会员-20
 */
abstract class Discount{
    protected Discount nextDiscount;
    public abstract int calculateBySourcePrice(int price);
}

class FirstBuy extends Discount{

    @Override
    public int calculateBySourcePrice(int price) {
        if(price>100){
            System.out.println("首次购买减20");
            price -= 20;
        }
        if(this.nextDiscount!=null){
            return super.nextDiscount.calculateBySourcePrice(price);
        }
        return price;
    }
}

class NewBuy extends Discount{

    @Override
    public int calculateBySourcePrice(int price) {
        if(price>200){
            System.out.println("满200减20");
            price -= 20;
        }
        if(this.nextDiscount!=null){
            return super.nextDiscount.calculateBySourcePrice(price);
        }
        return price;

    }
}

class VIPBuy extends Discount{

    @Override
    public int calculateBySourcePrice(int price) {
        System.out.println("VIP减10块");
        price -= 10;
        if(this.nextDiscount!=null){
            if(price>10){
                return super.nextDiscount.calculateBySourcePrice(price);
            }
        }
        return price;
    }
}

public class ChainPattern {
    public static void main(String[] args) {
        int price = 300;
        String produceStr = String.format("商品清单：苹果、香蕉、橘子，商品金额为：%d元。", price);
        System.out.println(produceStr);
        //声明责任链上的所有节点
        NewBuy newBuy = new NewBuy();
        FirstBuy firstBuy = new FirstBuy();
        VIPBuy vipBuy = new VIPBuy();
        //设置链中顺序
        newBuy.nextDiscount = firstBuy;
        firstBuy.nextDiscount = vipBuy;
        vipBuy.nextDiscount = null;
        //开始
        int total = newBuy.calculateBySourcePrice(price);
        System.out.println(String.format("所有商品优惠后金额为:%d",total));
    }

}
