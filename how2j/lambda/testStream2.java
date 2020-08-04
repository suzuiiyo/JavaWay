package lambda;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import charactor.Hero;

public class TestStream2 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for(int i=0; i<10; i++){
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("���ϳ�ʼ��֮��: ");
        System.out.println(heros);
        System.out.println("\n\t **********************\n");

        /*Collections.sort(heros);
        System.out.println(heros);
        System.out.println("Colloctions��sort����ɸѡ: " + heros.get(7));*/
        System.out.println("\n\t **********************\n");
        //lambda���ʽ����hp��������
        /*filter(heros, Hero::matched);
        System.out.println(heros);
        System.out.println("lambda���ʽɸѡ��" + heros.get(7));*/
        System.out.println("\n\t **********************\n");
        //ʹ�þۺϲ�������hp����
        System.out.println(heros);
        String name = heros.stream().sorted((h1,h2)->h1.hp>h2.hp?-1:1).skip(2).map(h->h.getName()).findFirst().get();       //�ۺϲ�������һ��String
        System.out.println("�ۺϲ���ɸѡhp�����ߵ�Ӣ��������: " + name);                                                       //.map��������ת������
    }

    private static void filter(List<Hero> heros, HeroChecker hChecker){      //����������������
        for(Hero h : heros){
            if(hChecker.test(h));
                //System.out.println(h);
        }
    }
}