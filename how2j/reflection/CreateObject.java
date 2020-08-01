package reflection;

import java.lang.reflect.Constructor;

import charactor.Hero;

public class CreateObject {
    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero h1 = new Hero();
        h1.name = "Lina";
        System.out.println(h1);

        try{
            //使用反射方式创建一个对象
            String className = "charactor.Hero";
            //类对象
            Class pClass = Class.forName(className);
            //构造器
            Constructor c = pClass.getConstructor();
            //通过构造器实例化
            Hero h2 = (Hero) c.newInstance();
            h2.name = "Luna";
            System.out.println(h2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}