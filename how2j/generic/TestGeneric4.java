package generic;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;

public class TestGeneric4 {
    public static void main(String[] args) {
        Hero h = new Hero();
        ADHero ad = new ADHero();
        //����ת����
        h = ad;

        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();

        //���෺��ת���෺��
        //hs = adhs;       //���෺���޷�ת��Ϊ���෺��

        //����ת����
        //adhs = hs;       //Ҳ�ǲ����е�
    }
}