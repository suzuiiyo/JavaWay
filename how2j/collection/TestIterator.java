package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import charactor.Hero;

public class TestIterator {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<Hero>();
        //��5��Hero��������
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero" + i));
        }
        //�ڶ��ֱ�����ʹ�õ�����
        System.out.println("---------ʹ��while��iterator---------");
        Iterator<Hero> it = heros.iterator();
        while(it.hasNext()){
            Hero h = it.next();
            System.out.println(h);
        }
        //��������forд��
        System.out.println("---------ʹ��for��iterator-----------");
        for(Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();){
            Hero hero = (Hero) iterator.next();
            System.out.println(hero);
        }
    }
}