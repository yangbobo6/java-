package com.yangbo.collection1;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
* ArrayList在并发的情况下是不安全的，
* 解决方案：
* 1.换成vector就可以
* 2.使用Collections.synchronizedList(new ArrayList<>());
* 3.使用JUC包中 List<String> arrayList = new CopyOnWriteArrayList<>();
* 写诗时候复制
* */

public class ListTest {
    public static void main(String[] args) {
        //List<Object> arrayList1 = new Vector<>();
        //List<Object> arrayList2 = Collections.synchronizedList(new ArrayList<>());
        //List<Object> arrayList = new ArrayList<>();
        List<String> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(arrayList);
            },String.valueOf(i)).start();
        }
    }
}
