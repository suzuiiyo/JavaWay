package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TestContain {
    public static void main(String[] args){
        ArrayList heros = new ArrayList<>();

        //��ʼ��5������
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        //�ж�һ�������Ƿ���������
        //�жϱ�׼:�Ƿ���ͬһ������,������name�Ƿ���ͬ
        System.out.println("��Ȼһ���¶�������Ҳ��hero1������contains�ķ����ǣ�");
        System.out.println(heros.contains(new Hero("hero1")));
        System.out.println("����specialHero���жϣ� contains�ķ���ʱ: ");
        System.out.println(heros.contains(specialHero));
    }
}