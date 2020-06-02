package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import charactor.Hero;

public class statisticksArrayList {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        for(int i=0; i<2000*1000; i++){
            herolist.add(new Hero("hero " + i));
        }
        Collections.shuffle(herolist);
        System.out.println("����׼�����");
        long[] time = new long[10];
        for(int i=0; i<10; i++){
            long start = System.currentTimeMillis();
            for(Hero h : herolist){
                if(h.getName().equals("hero 1000000")){
                    System.out.println("�ҵ���hero! " + h);
                }
            }
            long end = System.currentTimeMillis();
            time[i] = end - start;
        }
        for(long t : time){
            System.out.println("ͳ�ƻ���ʱ��: " + t + "����");
        }
    }
}