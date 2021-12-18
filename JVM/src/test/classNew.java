package test;

public class classNew {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("classLoading.Initable");
        Object o = clazz.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
    }
}
