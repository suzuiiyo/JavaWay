package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import charactor.Hero;

public class testStream {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for(int i=0; i<5; i++){
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        //�ܵ�Դ�Ǽ���
        heros
            .stream()                                     //�޹�������
            .forEach(h -> System.out.println(h));
        
        System.out.println("**************");

        //�ܵ�Դ������
        Hero hs[] = heros.toArray(new Hero[heros.size()]);
        Arrays.stream(hs)                               //����ת����Դ
        .forEach(h->System.out.println(h));
    }
}