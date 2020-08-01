package reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import charactor.Hero;
import charactor1.APHero;

public class ObjectConfig {
    public static void main(String[] args) throws InterruptedException{
        APHero h = (APHero) getHero();
        System.out.println(h);
    }

    public static Hero getHero(){
        File f = new File("d:/Studio/JavaWay/AC/DC/hero.config");

        try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){
            String className = null;
            APHero aphero = (APHero) Class.forName(className).getConstructor().newInstance();
            return aphero;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}