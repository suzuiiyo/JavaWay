package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class TestListInterface {
    public static void main(String[] args) {
        //ArrayListʵ���˽ӿ�List
        //������д�������������Ϊ�ӿ�List����
        //ע�⣺��java.util.List,������java.awt.List
        //�ӿ�����ָ���������(��̬)
        List heros = new ArrayList();
        heros.add(new Hero("С¹"));
        System.out.println(heros.size());
    }
}