package reflection;

import java.lang.reflect.Field;

import charactor.Hero;

public class SetAccess {
    public static void main(String[] args) {
        Hero h = new Hero();
        //ʹ�ô�ͳ��ʽ�޸�name��ֵΪ����������
        h.name = "����������";
        h.setName("����������");
        h.setUltimate(345);
        System.out.println(h);

        //��������޸�private����
        try{
            Field f1 = h.getClass().getDeclaredField("name");
            Field f2 = h.getClass().getDeclaredField("ultimate");
            //f2.setAccessible(true);
            //�޸�����ֶε�ֵ
            f1.set(h, "��Ĭ��ʿ");
            f2.set(h, 234);
            //��ӡ���޸ĺ��ֵ
            System.out.println(h);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}