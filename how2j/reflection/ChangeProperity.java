package reflection;

import java.lang.reflect.Field;

import charactor.Hero;

public class ChangeProperity {
    public static void main(String[] args) {
        Hero h = new Hero();
        //ʹ�ô�ͳ��ʽ�޸�name��ֵΪLina
        h.setName("Lina");
        System.out.println(h.name);

        //ʹ�÷�������޸�name����
        try{
            //��ȡ��Hero�����ֽ���name���ֶ�
            Field f1 = h.getClass().getDeclaredField("name");
            //�޸�����ֶε�ֵ
            f1.set(h, "Shiina");
            //��ӡ���޸ĺ��ֵ
            System.out.println(h.name);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}