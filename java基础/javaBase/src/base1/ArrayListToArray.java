package base1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yangbo
 * @Date: 2022-03-21-10:38
 * @Description:
 */
public class ArrayListToArray {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4");
        System.out.println(list.get(0));
        try {
            list.add("6");
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("异常略");
        }
        Class<? extends List> aClass = list.getClass();
        System.out.println(aClass);
        List<String > list1 = new ArrayList<>();
        Class<? extends List> aClass1 = list1.getClass();
        System.out.println(aClass1);

        Integer[] integers = {1,2,3};
        List list2 = Arrays.stream(integers).collect(Collectors.toList());





    }
}
