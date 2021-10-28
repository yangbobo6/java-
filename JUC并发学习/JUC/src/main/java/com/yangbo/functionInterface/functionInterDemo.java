package com.yangbo.functionInterface;

import java.util.function.Function;

public class functionInterDemo {
    public static void main(String[] args) {
        Function function = new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };

        //lambda表达式
        Function function1 = (str)->{return str;};
        System.out.println(function1.apply("abc"));
    }
}
