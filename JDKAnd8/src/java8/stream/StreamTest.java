package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: yangbo
 * @Date: 2022-03-03-15:45
 * @Description: Stream依然不存储数据，不同的是它可以检索(Retrieve)和
 * 逻辑处理集合数据、包括筛选、排序、统计、计数等。可以想象成是 Sql 语句。
 * 它的源数据可以是 Collection、Array 等。由于它的方法参数都是函数式接口类型，所以一般和 Lambda 配合使用。
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("yangbo","tanjing","xiaozhu","xiaoyang","abc","yangbo");
        //返回符合条件的流
        Stream<String> stringStream = strings.stream().filter(s->"yangbo".equals(s));
        System.out.println(stringStream.count());

        //stream  打印元素
        strings.forEach(System.out::println);
        System.out.println("-----");

        //获取到1个元素的stream,将流转化为数组打印
        Stream<String> limit = strings.stream().limit(2);
        String[] strings1 = limit.toArray(String[]::new);
        for (String s:strings1
             ) {
            System.out.println(s);
        }
        System.out.println("=================");

        //map 对每个元素进行操作 返回 新流
        Stream<String> mapStream = strings.stream().map(s -> s+"22");
        mapStream.forEach(System.out::println);
        mapStream.count();
    }
}
