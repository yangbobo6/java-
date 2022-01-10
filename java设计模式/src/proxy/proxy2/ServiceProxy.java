package proxy.proxy2;

/**
 * @author zhangsan
 * @date 2021-04-18 11:10
 */
public class ServiceProxy implements Crud {
    private Service service ;
    public void setService(Service service){
        this.service = service;
    }

    @Override
    public void add() {
        log("add");
        service.add();
    }

    @Override
    public void delete() {
        log("delete");
        service.delete();
    }

    @Override
    public void quary() {
        log("quary");
        service.quary();
    }

    @Override
    public void update() {
        log("delete");
        service.delete();

    }

    public void log(String msg){
        System.out.println("[debug]使用"+msg+"方法");
    }
}
