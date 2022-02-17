package base1;

/**
 * @Author: yangbo
 * @Date: 2022-02-17-19:04
 * @Description: 可变长参数
 */
public class VariableLengthArgument {

    public static void printVariable(String... arg){
        for (String s:arg
             ) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        VariableLengthArgument.printVariable("a");
        VariableLengthArgument.printVariable("a","b");
    }
}
