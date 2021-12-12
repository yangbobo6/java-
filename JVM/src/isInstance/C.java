package isInstance;
class A{}

class B extends A{}

public class C {
    static void test(Object x){
        System.out.println(x.getClass());
        System.out.println("Testing x of type  "+x.getClass());
        System.out.println("x is instanceof A  "+(x instanceof A));
        System.out.println("x is instanceof B  "+(x instanceof B));
        System.out.println("A isInstance(x)  "+A.class.isInstance(x));
        System.out.println("B isInstance(x)  "+B.class.isInstance(x));

        System.out.println("x.getClass() == A.class  "+(x.getClass()==A.class));
        System.out.println("x.getClass() == B.class  "+(x.getClass()==B.class));

        System.out.println("x.getClass().equals(A.Class)  "+(x.getClass().equals(A.class)));
        System.out.println("x.getClass().equals(B.Class)  "+(x.getClass().equals(B.class)));
    }

    public static void main(String[] args) {
        System.out.println(A.class);
        test(new A());
        System.out.println("-------------------");
        System.out.println(B.class);
        test(new B());
    }
}
