package reflection;

import java.lang.reflect.Field;

import charactor.Hero;

public class ChangeProperity {
    public static void main(String[] args) {
        Hero h = new Hero();
        //使用传统方式修改name的值为Lina
        h.setName("Lina");
        System.out.println(h.name);

        //使用反射机制修改name属性
        try{
            //获取类Hero的名字叫做name的字段
            Field f1 = h.getClass().getDeclaredField("name");
            //修改这个字段的值
            f1.set(h, "Shiina");
            //打印被修改后的值
            System.out.println(h.name);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}