package reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;
import charactor1.APHero;

public class ObjectConfig2 {
    public static void main(String[] args) {
        File f = new File("d:/Studio/JavaWay/AC/DC/hero2.config");
        try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){
            ArrayList<String> list = new ArrayList<>();
            String str = null;
            while((str = br.readLine())!=null){
                list.add(str);
            }

            APHero aph = (APHero) Class.forName(list.get(0)).getConstructor().newInstance();
            //aph.setName(list.get(1));
            Field hero1NameField = APHero.class.getField("name");
            hero1NameField.set(aph, list.get(1));

            ADHero adh = (ADHero) Class.forName(list.get(2)).getConstructor().newInstance();
            Field hero2NameField = ADHero.class.getField("name");
            //adh.setName(list.get(3));
            hero2NameField.set(adh, list.get(3));

            //传统方式调用
            //aph.magicAttack(adh);
            //根据反射，获取attackHero方法,并且调用aph的这个方法，参数是hero2
            Method magicAttackMethod = Class.forName(list.get(0)).getMethod("magicAttack", Hero.class);
            magicAttackMethod.invoke(aph, adh);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}