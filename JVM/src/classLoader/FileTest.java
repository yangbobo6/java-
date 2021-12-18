package classLoader;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("E:\\javaLearn\\hello.txt");
        System.out.println(file.getName().getBytes());
    }
}
