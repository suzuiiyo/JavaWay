package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import charactor.Hero;

public class TestObjetcStream {

    public static void main(String[] args) {
        //创建一个BowieHero对象
        //要把BowieHero对象保存到直接保存到文件上，务必让Hero类实现Serializable接口
        Hero h = new Hero();
        h.name = "teemo";      //不同包子类，无法在类中通过父类对象访问父类protected属性
        h.hp = 616;

        //准备一个文件用域保存该对象
        File f = new File("d:/Studio/JavaWay/AC/DC/HeroSerial.txt");
        try(//创建对象输出流
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //创建对象输入流
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            oos.writeObject(h);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}