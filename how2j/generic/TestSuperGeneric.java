package generic;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;

public class TestSuperGeneric {
    public static void main(String[] args) {
        ArrayList<? super Hero> heroList = new ArrayList<>();
        //? super Hero��ʾherolist�ķ�����Hero�����丸�෺��
        //heroList�ķ��Ϳ�����Hero
        //heroList�ķ��Ϳ�����Object

        //���Խ���Բ���Hero
        heroList.add(new Hero());
        //Ҳ���Բ���Hero������
        heroList.add(new ADHero());
        heroList.add(new APHero());

        //���ǣ����ܴ�����ȡ���ݳ���,��Ϊ�䷺�Ϳ�����Object����ObjectǿתHero��ʧ��
        //Hero h = heroList.get(0);

    }
}