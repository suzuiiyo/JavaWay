package collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestCollections {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        int[] arr = new int[20];
        for(int i : arr){
            i = (int)(Math.random()*100);
            intList.add(i);
        }
        System.out.println("ԭ����arraylist: " + intList);

        Collections.reverse(intList);
        System.out.println("revesr֮��: " + intList);
        Collections.shuffle(intList);
        System.out.println("shuffle֮��: "  + intList);
        Collections.sort(intList);
        System.out.println("sort֮��" + intList);
        Collections.swap(intList, 1, 5);
        System.out.println("swap֮��" + intList);
        Collections.rotate(intList, 2);
        System.out.println("rotate֮��" + intList);
        List<Integer> safeSynList = Collections.synchronizedList(intList);
        System.out.println("�̰߳�ȫ��֮��: " + safeSynList);
    }
}