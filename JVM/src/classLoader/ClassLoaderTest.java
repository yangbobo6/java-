package classLoader;
/*
    @author: yangbo
* 2021/12/16
* */

import java.io.*;

//自定义classLoader
class FileClassLoader extends ClassLoader{
    private String rootDir;
    public FileClassLoader(String rootDir){
        this.rootDir = rootDir;
    }

    /**
     * 编写findClass方法的逻辑
     * @param name
     * @return
     * @throws ClassNotFoundException
     * 自定义的类加载逻辑写在findClass()方法中，
     */
    //编写获取类的字节码并创建class对象 的逻辑
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if(classData==null){
            throw new ClassNotFoundException();
        }else {
            //defineClass()方法是用来将byte字节流解析成JVM能够识别的Class对象
            return defineClass(name,classData,0,classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     * @param className
     * @return
     */
    //编写 读取字节流 的方法
    private byte[] getClassData(String className){
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int byteNumRead = 0;
            //读取类的字节码
            while((byteNumRead=ins.read(buffer))!=-1){
                baos.write(buffer,0,byteNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     * @param className
     * @return
     */
    private String classNameToPath(String className){
        return rootDir+ File.separatorChar+className.replace('.',File.separatorChar)+".class";
    }


}


public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException{
        //FileClassLoader loader1 = new FileClassLoader("");

        /*System.out.println(loader1.getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());*/

        /**
         输出结果:
         自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
         系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
         AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
         ExtClassLoader的父类加载器: null
         */

        //创建两个不同的自定义类加载器实例
        String rootDir = "D:\\JAVA学习\\java-\\JVM\\src";
        FileClassLoader loader2 = new FileClassLoader(rootDir);
        FileClassLoader loader3 = new FileClassLoader(rootDir);
        //通过findClass创建类的class对象
        Class<?> object1 = loader2.findClass("classloader.ClassLoaderTest");
        Class<?> object2 = loader3.findClass("classloader.ClassLoaderTest");

        System.out.println("1"+object1.hashCode());
        System.out.println("2"+object2.hashCode());


    }
}
