package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TestIndexOf {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        //��ʼ��5������
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("specialHero������λ��: " + heros.indexOf(specialHero));
        System.out.println("�µ�Ӣ�ۣ�����������\"hero1\"������λ�ã�" + heros.indexOf(new Hero("hero1")));
    }
}