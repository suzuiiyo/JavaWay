package collection;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSerialsSet {
    public static void main(String[] args) {
        HashSet<Integer> numberSet1 = new HashSet<>();
        //HashSet中的数据不是按照插入顺序存放的
        numberSet1.add(88);
        numberSet1.add(8);
        numberSet1.add(888);
        System.out.println(numberSet1);

        //LinkedHashSet中的数据市按照插入顺序粗存放
        LinkedHashSet<Integer> numberSet2 = new LinkedHashSet<>();
        numberSet2.add(88);
        numberSet2.add(8);
        numberSet2.add(888);
        System.out.println(numberSet2);

        //TreeSet中的数据是进行了排序的
        TreeSet<Integer> numberSet3 = new TreeSet<>();
        numberSet3.add(88);
        numberSet3.add(8);
        numberSet3.add(888);
        System.out.println(numberSet3);
    }
}