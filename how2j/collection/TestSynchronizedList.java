package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSynchronizedList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Collections.synchronizedList(list1);
        for(Integer i : list1){
            System.out.println(i + " ");
        }
        System.out.println(" \n*******************\n");
        for(Integer i : list2){
            System.out.println(i + " ");
        }
    }
}