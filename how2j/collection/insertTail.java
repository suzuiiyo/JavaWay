package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class insertTail {
    public static void main(String[] args){
        List<Integer> l;
        l = new ArrayList<>();
        System.out.println(l);
        insertTail(l, "ArrayList");
        System.out.println(l);

        l = new LinkedList<>();
        insertTail(l, "LinkedList");
    }

    public static void insertTail(List<Integer> l, String type){
        int total = 1000 * 100;
        final int number = l.size()-1;
        long start = System.currentTimeMillis();
        for(int i=0; i<total; i++){
            l.add(i, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 最后面插入%d条数据，总共耗时%d毫秒 %n", type, total, end-start);
    }
}