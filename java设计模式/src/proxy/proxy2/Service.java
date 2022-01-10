package proxy.proxy2;

/**
 * @author zhangsan
 * @date 2021-04-18 11:08
 */
public class Service implements Crud {
    @Override
    public void add() {
        System.out.println("增加一个");
    }

    @Override
    public void delete() {
        System.out.println("删除一个");
    }

    @Override
    public void quary() {
        System.out.println("查找");
    }

    @Override
    public void update() {
        System.out.println("更新一个");
    }
}
