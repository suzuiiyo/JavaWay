package reflection;

import java.lang.reflect.Constructor;

import charactor.Hero;

public class CreateObject {
    public static void main(String[] args) {
        //��ͳ��ʹ��new�ķ�ʽ��������
        Hero h1 = new Hero();
        h1.name = "Lina";
        System.out.println(h1);

        try{
            //ʹ�÷��䷽ʽ����һ������
            String className = "charactor.Hero";
            //�����
            Class pClass = Class.forName(className);
            //������
            Constructor c = pClass.getConstructor();
            //ͨ��������ʵ����
            Hero h2 = (Hero) c.newInstance();
            h2.name = "Luna";
            System.out.println(h2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}