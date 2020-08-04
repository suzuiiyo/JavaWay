package reflection;

import java.lang.reflect.Field;

import charactor.Hero;

public class SetAccess {
    public static void main(String[] args) {
        Hero h = new Hero();
        //使用传统方式修改name的值为半人马酋长
        h.name = "半人马酋长";
        h.setName("半人马酋长");
        h.setUltimate(345);
        System.out.println(h);

        //反射机制修改private属性
        try{
            Field f1 = h.getClass().getDeclaredField("name");
            Field f2 = h.getClass().getDeclaredField("ultimate");
            //f2.setAccessible(true);
            //修改这个字段的值
            f1.set(h, "沉默术士");
            f2.set(h, 234);
            //打印被修改后的值
            System.out.println(h);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}