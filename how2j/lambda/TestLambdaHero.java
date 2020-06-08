package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import charactor.Hero;

public class TestLambdaHero {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<10; i++){
            herolist.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ���: ");
        System.out.println(herolist);
        System.out.println("\n\t****************************\n");

        Collections.sort(herolist, (h1, h2)->h1.hp>h2.hp?1:-1);                 //�Ƚ���Ҳ��һ�ֹ�����,ɸѡ���������Ķ���
        System.out.println(herolist);
    }
}