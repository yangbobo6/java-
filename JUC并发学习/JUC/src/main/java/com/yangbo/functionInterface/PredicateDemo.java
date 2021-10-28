package com.yangbo.functionInterface;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        //判断字符串是否为空
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        Predicate<String> predicate1 = (str)-> {return str.isEmpty();};
        System.out.println(predicate1.test(""));
    }
}
