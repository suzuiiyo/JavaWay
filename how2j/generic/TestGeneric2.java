package generic;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;
import charactor1.APHero;
import property.Item;

public class TestGeneric2 {
    public static void main(String[] args){
        //���ڲ����÷��͵�����,�����������Ӣ�ۣ�Ҳ�������������Ʒ
        List heros = new ArrayList();

        heros.add(new Hero("����"));

        //����������Ӣ�۵�����,����Ҳ���Դ����Ʒ��
        heros.add(new Item("Ѫƿ"));

        //����ת�ͻ��������
        Hero h1 = (Hero) heros.get(0);
        //��������������ŵĶ���̫���ʱ��,�ͼǲ�����ĸ�λ�÷ŵ����������͵Ķ�����
        //����תΪHero  ֻ��ת��Item
        Item h2 = (Item) heros.get(1);

        //���뷺��Generic
        //����������ʱ�򣬾�ָ��������������ֻ�ܷ�Hero,�������ľͻᱨ��
        List<Hero> genericheros = new ArrayList<Hero>();
        genericheros.add(new Hero("��Ī"));
        //�������Herole���ͣ������ͷŲ�����
        //genericheros.add(new Item("Ѫƿ"));

        //����֮�⣬���ܴ��Hero������
        genericheros.add(new APHero());

        //������ȡ�����ݵ�ʱ�򣬲���Ҫ�ٽ���ת���ˣ���Ϊ����϶��Ƿŵ�Hero����������
        Hero h = genericheros.get(0);
        System.out.println(h);

        for( Object b : heros){
            System.out.println(b);
        }
    }
}