package collection;

import java.util.ArrayList;

import charactor.Hero;

public class TesttoArray {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        //��ʼ��5������
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);
        System.out.println(heros);
        Hero hs[] = (Hero[])heros.toArray(new Hero[]{});   //��toArray����һ��ָ�����͵Ķ������ת���ɶ�Ӧ���͵�����,����ֻ��ת����Objetc����
        System.out.println("����: " + hs);
    }
}
    