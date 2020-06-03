package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import charactor.Hero;
import property.Item;

public class TestComparetor {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        List<Item> items = new ArrayList<Item>();

        for(int i=0; i<10; i++){
            //ͨ�����ֵʵ����hero��hp��damage
            heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
            items.add(new Item("item" + i, (int)(Math.random()*100)));
        }
        System.out.println("��ʼ����ļ���: ");
        System.out.println(heros);
        System.out.println("\n\t *****************\n");
        System.out.println(items);
        System.out.println("\n\t ***************************************\n");

        //ֱ�ӵ���sort����ֱ������,��ΪHero�и�������
        //���װ����������Խ��бȽ�,CollectionsҲ��֪������ȥ��������û����
        //Collections.sort(heros);

        //����Comparator��ָ���Ƚϵ��㷨
        /*Comparator<Hero> c = new Comparator<Hero>(){
            @Override
            public int compare(Hero h1, Hero h2){
                //����hp��������
                if(h1.hp>=h2.hp)
                    return 1;          //������ʾh1��h2Ҫ��
                else
                    return -1;
            }
        };*/

        Collections.sort(heros);
        Collections.sort(items);
        System.out.println("�����˺�����������Hero����: ");
        System.out.println(heros);
        System.out.println("\n\t *****************\n");
        System.out.println("���ռ۸���������Item����: ");
        System.out.println(items);
    }
}