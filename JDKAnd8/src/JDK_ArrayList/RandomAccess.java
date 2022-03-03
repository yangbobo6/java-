package JDK_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class RandomAccess {
    public static void main(String[] args) {
        ArrayList arrayList  = new ArrayList<>();
        for (int i = 0; i < 9999; i++) {
            arrayList.add(i);
        }
        // 测试随机访问的效率：
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行随机访问所用时间："+(endTime-startTime));
        // 测试顺序访问的效率：
        startTime = System.currentTimeMillis();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("执行顺序访问所用时间："+(endTime-startTime));
    }
}
