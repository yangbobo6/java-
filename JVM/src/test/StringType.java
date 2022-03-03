package test;

/**
 * @Author: yangbo
 * @Date: 2022-03-01-10:23
 * @Description:
 */
public class StringType {
    public static void main(String[] args) {
        /*String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        System.out.println(str4.equals(str3));
        System.out.println(str4.equals(str5));*/

        System.out.println("----------------------------");

        String str1 = "abcd";
        String str2 = new String("abcd");
        String str3 = new String("abcd");
        System.out.println(str1==str2);
        System.out.println(str2==str3);

        System.out.println(str1.equals(str2));
        final String str4 = "123";

    }

}

