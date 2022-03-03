package JDK_ArrayList;

import java.util.ArrayList;

public class MethodTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);

        arrayList.retainAll(arrayList1);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("----------|");
        System.out.println(arrayList.toString());

    }
}
