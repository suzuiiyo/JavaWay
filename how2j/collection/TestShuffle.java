package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestShuffle {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        int[] arr = new int[10];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
            intList.add(i);
        }
        int count = 0;
        for(int i=0; i<1000*1000; i++){
            Collections.shuffle(intList);
            if(intList.get(0) == 3 && intList.get(1) == 1 && intList.get(2) ==4)
                count++;
        }
        System.out.println("达成次数: " + count);
        double rate = count/1000000.0;           //分子或分母需要有一个是float型,才能算出double型数值
        System.out.println("达成概率是: " + rate*100 + "%");
    }
}