package collection;

import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<String>();
        names.add("gareen");
        System.out.println(names); 

        //�ڶ��β���ͬ��������,�ǲ��ȥ�ģ�������ֻ�ᱣ��һ��
        names.add("gareen");
        System.out.println(names);
    }
}