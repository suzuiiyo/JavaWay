package collection;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashTable {
    public static void main(String[] args) {
        //HashMap��HashT��HashTable��ʵ����Map�ӿڣ����Ǽ�ֵ�Ա������ݵķ�ʽ
        HashMap<String, String> hashMap = new HashMap<String, String>();

        //HashMap������null��Ϊkey�� ��value
        hashMap.put(null, "123");
        hashMap.put("123", null);
        System.out.println(hashMap);

        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        //Hashtabble������null��key��������null��value
        //hashtable.put(null, "123");
        //hashtable.put("123", null);
    }
}