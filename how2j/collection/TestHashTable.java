package collection;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashTable {
    public static void main(String[] args) {
        //HashMap和HashT和HashTable都实现了Map接口，都是键值对保存数据的方式
        HashMap<String, String> hashMap = new HashMap<String, String>();

        //HashMap可以用null作为key， 作value
        hashMap.put(null, "123");
        hashMap.put("123", null);
        System.out.println(hashMap);

        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        //Hashtabble不能用null作key，不能用null作value
        //hashtable.put(null, "123");
        //hashtable.put("123", null);
    }
}