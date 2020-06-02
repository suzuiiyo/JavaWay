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
        System.out.println("数据准备完成");
        long[] time = new long[10];
        for(int i=0; i<10; i++){
            long start = System.currentTimeMillis();
            /*for(Map.Entry<String, Hero> entry : heroMap.entrySet()){
                if(entry.getKey().equals("hero 1000000")){          //不需要遍历直接查找Key
                    System.out.println(entry.getKey());
                }
            }*/
            Hero target = heroMap.get("hero 1000000");
            System.out.println("找到了hero！" + target.name);
            long end = System.currentTimeMillis();
            time[i] = end - start;
        }
        for(long t : time){
            System.out.println("统计花费时间: " + t + "毫秒");
        }
    }
}