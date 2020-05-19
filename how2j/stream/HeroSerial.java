package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import charactor.Hero;

public class HeroSerial extends Hero{
    private static final long serialVersionUID = 1L;
    public static void main(String[] args){
        Hero[] heros = new Hero[10];
        for(int i=0; i<10; i++){
            heros[i] = new Hero();    //��ʼ������Ԫ�أ�����㱨nullpointerException
        }
        for(int i=0; i<heros.length; i++){
            heros[i].name = "Monkey:" + i;
            heros[i].hp = (float)Math.random()*1000;
        }
        File f =  new File("d:/Studio/JavaWay/AC/DC/heros.txt");
        try(FileOutputStream fou = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fou);
            FileInputStream fin = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fin)    
        ){
            oos.writeObject(heros);
            for(Hero h : heros)
                System.out.print(h.name + " ");
            System.out.println("\n\n ****************************** \n");
            Hero[] heros2 = (Hero[]) ois.readObject();     //ע������ط�ת���Ĳ���Hero,����Hero[],����ᱨClassCastException
            for(Hero h2 : heros2)
                System.out.print(h2.name + " ");
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}