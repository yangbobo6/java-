package jvm;

public class SweetShop {
    public static void print(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("after creating Candy");
        try {
            Class.forName("jvm.Gum");
        }catch (ClassNotFoundException e){
            print("could not found Gum");
        }
        print("After Class.forName(\"jvm.Cum\")");
        new Cookie();
        print("After creating Cookie");
    }

}
class Candy{
    static {
        System.out.println("loading Candy");
    }
}

class Gum{
    static {
        System.out.println("loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("loading Cookie");
    }
}
class test{
    public static void main(String[] args) {

        //通过Class.forName获取Gum的Class对象
        try{
            Class clazz = Class.forName("jvm.Gum");
            System.out.println("forName=clazz:"+clazz.getName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        //通过实例对象获取Gum的class对象
        Gum gum = new Gum();
        Class clazz2 = gum.getClass();
        System.out.println("new=clazz2:"+clazz2.getName());

        //Class字面常量的方式获取Class对象
        Class class3 = Gum.class;
        System.out.println("Class字面常量创建："+class3.getName());

        Class classBool = boolean.class;
        Class ClassBool2 = Boolean.TYPE;
        System.out.println(classBool.equals(ClassBool2));

        Class clazz4 = int.class;
        Class clazz5 = Integer.class;
        System.out.println(clazz4);
        System.out.println(clazz5);
    }
}
