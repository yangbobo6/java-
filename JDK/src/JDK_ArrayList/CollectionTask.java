package JDK_ArrayList;

import java.util.List;

public class CollectionTask implements Runnable{

    private List<String> list;
    public CollectionTask(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 把当前线程名字加入到集合中
        list.add(Thread.currentThread().getName());
    }
}
