package JDK_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws InterruptedException{
        //创建集合
        List<String> list = new ArrayList<>();
        //创建线程任务
        CollectionTask collectionTask = new CollectionTask(list);
        //开启50条线程
        for (int i = 0; i < 50; i++) {
            new Thread(collectionTask).start();
        }
        //确保线程执行完毕
        Thread.sleep(3000);
        /**
         * 如果ArrayList是线程安全的，则遍历集合可以得到50条数据，
         * 打印集合长度为50
         * 否则说明其不是线程安全的！
         */
        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------------");
        System.out.println("集合长度"+list.size());
    }
}
