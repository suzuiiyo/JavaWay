package generic;

import java.util.ArrayList;

import charactor.Hero;
import charactor1.ADHero;

public class TestGeneric4 {
    public static void main(String[] args) {
        Hero h = new Hero();
        ADHero ad = new ADHero();
        //子类转父类
        h = ad;

        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();

        //子类泛型转父类泛型
        //hs = adhs;       //子类泛型无法转换为父类泛型

        //父类转子类
        //adhs = hs;       //也是不可行的
    }
}