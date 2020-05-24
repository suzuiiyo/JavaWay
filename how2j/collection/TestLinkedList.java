package collection;

import java.util.LinkedList;

import charactor.Hero;

public class TestLinkedList {
    public static void main(String[] args){
        //LinkedList��һ��˫������ṹ��list
        LinkedList<Hero> ll = new LinkedList<Hero>();

        //���Կ��Ժܷ������ͷ����β����������
        //���������µ�Ӣ��
        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        //����ǰ������µ�Ӣ��
        ll.addFirst((new Hero("heroX")));
        System.out.println(ll);

        //�鿴��ǰ���Ӣ��
        System.out.println(ll.getFirst());
        //�鿴������Ӣ��
        System.out.println(ll.getLast());

        //�鿴���ᵼ��Ӣ�۱�ɾ��
        System.out.println(ll);
        //ȡ����ǰ���Ӣ��
        System.out.println(ll.removeFirst());

        //ȥ��������Ӣ��
        System.out.println(ll.removeLast());

        //ȡ���ᵼ��Ӣ�۱�ɾ��
        System.out.println(ll);
    }
}