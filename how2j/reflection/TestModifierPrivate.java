package reflection;

import java.lang.reflect.Field;

import charactor.Hero;

public class TestModifierPrivate {
    public static void main(String[] args) {
        try{
            Hero h = (Hero)Class.forName("charactor.Hero").getConstructor().newInstance();//�ɷ��䴴��Hero
            Field f1 = h.getClass().getDeclaredField("ultimate");
            Field f2 = h.getClass().getDeclaredField("name");
            System.out.println(f1);         //�ܹ���ȡ���ֶ�,���ܻ�ȡ��ֵ�����println(h.ultimate)�ᱨ��
            System.out.println(f2);         //�ܹ���ȡ���ֶκ�ֵ
            f2.set(h, "�����ʥ");
            System.out.println(f2);         //�����Զ�ֵ�����޸�

            Field[] fields = h.getClass().getDeclaredFields();
            for(int i=1; i<fields.length-1; i++){           //��i=1��ʼ����Ϊ��0����private static final serialName,�޷�����ȡ
                Field field = fields[i];
                System.out.println(field.get(h));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}