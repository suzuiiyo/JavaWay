package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class insertMiddle {
    public static void main(String[] args) {
        List<Integer> l;
        l = new ArrayList<>();
        insertMiddleList(l, "ArrayList");
        l = new LinkedList<>();
        insertMiddleList(l, "LinkedList");
    }

    public static void insertMiddleList(List<Integer> l, String type){
        int total = 1000 * 100;
        final int number = 3;
        long start = System.currentTimeMillis();
        for(int i=0; i<total; i++){
            l.add(i/2, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("��%s�м����%d�����ݣ��ܹ���ʱ%d���� %n", type, total, end-start);
    }
}