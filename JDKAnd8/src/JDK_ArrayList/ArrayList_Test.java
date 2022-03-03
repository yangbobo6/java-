package JDK_ArrayList;

import java.util.ArrayList;

public class ArrayList_Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        //user对象化
        User user = new User("yangbo");
        list.add("tanjing");
        list.add(user);
        System.out.println("------------原始ArrayList集合------------");
        System.out.println("list:"+list);

        //浅拷贝
        ArrayList clone = (ArrayList) list.clone();
        System.out.println(list == clone);
        System.out.println(list);
        System.out.println(clone);
        User u= (User)list.get(1);
        u.setName("tanzhuzhu");
        System.out.println(clone);
        System.out.println(((User) (clone.get(1))).getName());

    }
}
