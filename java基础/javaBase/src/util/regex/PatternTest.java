package util.regex;

import util.eum.ModelScope;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yangbo
 * @Date: 2022-04-28-17:23
 * @Description:
 */
public class PatternTest {
    //
    public static void main(String[] args) {

        Pattern compile = Pattern.compile("geeksforge*ks");
        Matcher match = compile.matcher("geeksforgeeks");
        System.out.println("match: "+match.toString());
        while(match.find()){
            String group = match.group(0);
            System.out.println("group(0): "+group);
            int i = group.indexOf("f");
            System.out.println(i);
        }
        


        boolean matches = Pattern.matches("geeksforge*ks", "geeksforgeeks");
        System.out.println(matches);
        
        
    }
}
