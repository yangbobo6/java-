package JDK_ArrayList;

public class Test03 {
    public static void main(String[] args) {
        //创建线程任务
        CollectionThread collectionThread = new CollectionThread();
        //开启10条任务
        for (int i = 0; i < 10; i++) {
            new Thread(collectionThread).start();
        }
    }
}
