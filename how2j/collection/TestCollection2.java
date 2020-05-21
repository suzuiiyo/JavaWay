package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class TestCollection2 {
    public static void main(String[] args){
        List<Hero> heros = new ArrayList<>();
        for(int i=0; i<10; i++){
            heros.add(new Hero("hero" + i));
            System.out.println(heros.toString() + " ");
        }
        boolean flag = false;
        for(Hero h : heros){
            if(h.name.equals("hero7")){
                flag = true;
            }
        }
        if(flag == true){
            System.out.println("找到了名字是hero7的Hero对象");
        }else {
            System.out.println("没有找到名字是hero7的对象");
        }
    }
}