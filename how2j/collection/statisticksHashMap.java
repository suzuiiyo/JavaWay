package collection;

import java.util.HashMap;

import charactor.Hero;

public class statisticksHashMap {
    public static void main(String[] args) {
        HashMap<String, Hero> heroMap = new HashMap<>();
        for(int i=0; i<2000*1000; i++){
            Hero h = new Hero("hero " + i);
            heroMap.put(h.name, h);
        }
        System.out.println("����׼�����");
        long[] time = new long[10];
        for(int i=0; i<10; i++){
            long start = System.currentTimeMillis();
            /*for(Map.Entry<String, Hero> entry : heroMap.entrySet()){
                if(entry.getKey().equals("hero 1000000")){          //����Ҫ����ֱ�Ӳ���Key
                    System.out.println(entry.getKey());
                }
            }*/
            Hero target = heroMap.get("hero 1000000");
            System.out.println("�ҵ���hero��" + target.name);
            long end = System.currentTimeMillis();
            time[i] = end - start;
        }
        for(long t : time){
            System.out.println("ͳ�ƻ���ʱ��: " + t + "����");
        }
    }
}