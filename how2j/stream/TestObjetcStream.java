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
        //����һ��BowieHero����
        //Ҫ��BowieHero���󱣴浽ֱ�ӱ��浽�ļ��ϣ������Hero��ʵ��Serializable�ӿ�
        Hero h = new Hero();
        h.name = "teemo";      //��ͬ�����࣬�޷�������ͨ�����������ʸ���protected����
        h.hp = 616;

        //׼��һ���ļ����򱣴�ö���
        File f = new File("d:/Studio/JavaWay/AC/DC/HeroSerial.txt");
        try(//�������������
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //��������������
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