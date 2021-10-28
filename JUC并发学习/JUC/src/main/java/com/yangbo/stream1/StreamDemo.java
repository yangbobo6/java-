package com.yangbo.stream1;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        User user1 = new User(1,"a",20);
        User user2 = new User(2,"b",10);
        User user3 = new User(3,"c",2);
        User user4 = new User(4,"d",30);
        User user5 = new User(5,"e",13);
        User user6 = new User(6,"f",54);
        List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6);
        //计算交给流
        //链式编程
        list.stream()
                .filter((u)->{return u.getId()%2==0;})
                .filter((u)->{return u.getAge()>=15;})
                .map((u)->{return u.getName().toUpperCase();})
                .sorted((uu1,uu2)->{
                    return uu2.compareTo(uu1);
                })
                .limit(1)
                .forEach(System.out::println);
    }
}
