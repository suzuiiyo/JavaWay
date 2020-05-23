package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class TestRemove2 {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for(int i=0; i<100; i++){
            heros.add(new Hero("hero" + i));
        }
        System.out.println(heros);
        
        int count =0;                   //记录操作次数
        for(int i=0; i<heros.size(); i += 8){
            heros.remove(i-count);
            count++;
        }
        System.out.println(heros);
    }
}