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
        System.out.println("原来的arraylist: " + intList);

        Collections.reverse(intList);
        System.out.println("revesr之后: " + intList);
        Collections.shuffle(intList);
        System.out.println("shuffle之后: "  + intList);
        Collections.sort(intList);
        System.out.println("sort之后：" + intList);
        Collections.swap(intList, 1, 5);
        System.out.println("swap之后：" + intList);
        Collections.rotate(intList, 2);
        System.out.println("rotate之后：" + intList);
        List<Integer> safeSynList = Collections.synchronizedList(intList);
        System.out.println("线程安全化之后: " + safeSynList);
    }
}