package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import charactor.Hero;
import java.util.Collections;

public class testComparator {
    public static void main(String[] args) {
        List<Hero> herolist = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<10; i++){
            herolist.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ���: ");
        System.out.println(herolist);
        System.out.println("ʹ�þ�̬�����ù��˽��: ");
        Collections.sort(herolist, (h1, h2)->testComparator.compare(h1, h2));    //����hp��������
        System.out.println(herolist);
        System.out.println("ʹ�������ж��󷽷��õ��Ĺ��˽��: ");
        Collections.sort(herolist, Hero::compareTo);   //����damage��������
        System.out.println(herolist);
    }

    public static int compare(Hero h1, Hero h2){
        return h1.hp>=h2.hp?1:-1;                           //�Ƚ�������
    }
}