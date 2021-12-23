package JDK_ArrayList;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionThread implements Runnable{
    private static ArrayList<String> list1= new ArrayList<>();
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("Tanzhuzhu");
        list.add("Tanxiaozhu");
        list.add("tanJing");
    }

    @Override
    public void run() {
        for (String value:list
             ) {
            System.out.println(value);
            //在读取数据的同时又向集合写入数据
            list.add("Coco");
        }
    }
}
