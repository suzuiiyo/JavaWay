package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class TestCollection {
    public static void main(String[] args){
        //����ľ�����
        //Hero heros[] = new Hero[10];
        //����������10������
        //���õ�������˷���
        //����10�ĸ������ַŲ���
        //heros[0] = new Hero("����", 356);
        //heros[20] = new Hero("��ҽ");

        //������ArrayList heros = new ArrayList();
        ArrayList heros = new ArrayList();
        heros.add(new Hero("����"));
        System.out.println(heros.size());
        System.out.println(heros);          //�˴���Ϊ��д��Hero���toString����name�����򷵻ع�ϣ

        heros.add(new Hero("��ҽ"));
        System.out.println(heros.size());
        System.out.println(heros);

        List<Hero> heros2 = new ArrayList<>();
        //�Ž�����
        for(int i=0; i<5; i++){
            heros2.add(new Hero("hero" + i));
            System.out.println(heros2);
        }
    }
}