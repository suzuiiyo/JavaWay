package generic;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.APHero;

public class TestExtendsGeneric {
    public static void main(String[] args) {
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();
        apHeroList.add(new APHero());

        ArrayList<? extends Hero> heroList = apHeroList;
        //? extend Hero��ʾ����һ��Hero���͵����෺��
        //heroList �ķ��Ϳ�����Hero
        //heroList �ķ��Ϳ�����APHero
        //heroList �ķ��Ϳ�����ADHero

        //����ȷ����£���heroListȡ�����Ķ���һ���¿���ת�ͳ�Hero��
        Hero h= heroList.get(0);
        //���ǣ�����������Ŷ���
        //heroList.add(new ADHero());   //�������. ������Hero��Ҳ�����������
    }
}