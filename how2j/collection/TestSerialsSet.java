package collection;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSerialsSet {
    public static void main(String[] args) {
        HashSet<Integer> numberSet1 = new HashSet<>();
        //HashSet�е����ݲ��ǰ��ղ���˳���ŵ�
        numberSet1.add(88);
        numberSet1.add(8);
        numberSet1.add(888);
        System.out.println(numberSet1);

        //LinkedHashSet�е������а��ղ���˳��ִ��
        LinkedHashSet<Integer> numberSet2 = new LinkedHashSet<>();
        numberSet2.add(88);
        numberSet2.add(8);
        numberSet2.add(888);
        System.out.println(numberSet2);

        //TreeSet�е������ǽ����������
        TreeSet<Integer> numberSet3 = new TreeSet<>();
        numberSet3.add(88);
        numberSet3.add(8);
        numberSet3.add(888);
        System.out.println(numberSet3);
    }
}