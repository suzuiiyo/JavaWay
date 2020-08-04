package reflection;

import java.lang.reflect.Field;

import charactor.Hero;

public class TestModifierPrivate {
    public static void main(String[] args) {
        try{
            Hero h = (Hero)Class.forName("charactor.Hero").getConstructor().newInstance();//由反射创建Hero
            Field f1 = h.getClass().getDeclaredField("ultimate");
            Field f2 = h.getClass().getDeclaredField("name");
            System.out.println(f1);         //能够获取到字段,不能获取到值，如果println(h.ultimate)会报错
            System.out.println(f2);         //能够获取到字段和值
            f2.set(h, "齐天大圣");
            System.out.println(f2);         //并可以对值进行修改

            Field[] fields = h.getClass().getDeclaredFields();
            for(int i=1; i<fields.length-1; i++){           //从i=1开始是因为第0个事private static final serialName,无法被读取
                Field field = fields[i];
                System.out.println(field.get(h));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}