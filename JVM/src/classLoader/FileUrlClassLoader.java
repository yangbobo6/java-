package classLoader;

import java.io.File;
import java.net.*;

public class FileUrlClassLoader extends URLClassLoader {


    public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls) {
        super(urls);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public static void main(String[] args) throws MalformedURLException {
        String rootDir = "D:\\JAVA学习\\java-\\JVM\\src";
        //创建自定义文件加载器
        File file = new File(rootDir);
        //file to uri
        URI uri = file.toURI();
        URL[] urls= {uri.toURL()};

        FileUrlClassLoader loader = new FileUrlClassLoader(urls);

        try {
            //加载指定的class文件
            Class<?> obj1 = loader.loadClass("classLoader.DemoObj");
            System.out.println(obj1.getDeclaredConstructor().newInstance().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
