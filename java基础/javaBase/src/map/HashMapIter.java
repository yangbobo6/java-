package map;

import java.net.InterfaceAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: yangbo
 * @Date: 2022-04-12-12:10
 * @Description:
 */
public class HashMapIter {

    public static void main(String[] args) {
        Map<String,String> hashmap = new HashMap<String, String>();
        hashmap.put("name","yangbo");
        hashmap.put("age","20");
        hashmap.put("adress","cn");

        Iterator<Map.Entry<String,String>> iterator = hashmap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Iterator<String> iterator1 = hashmap.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            System.out.println(key);
            System.out.println(hashmap.get(key));
        }

        for (Map.Entry<String,String> map:hashmap.entrySet()
             ) {
            map.getValue();
            map.getValue();
        }

        // 遍历
        hashmap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }
    
}
