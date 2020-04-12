package charactor;

import charactor1.ADHero;
import charactor1.Support;

public class Hero5 {
    public String name;
    protected float hp;
    
    public static void main(String[] args){
        Hero h = new Hero();
        ADHero ad = new ADHero();
        Support s = new Support();

        h = ad;
        ad = (ADHero) h;
        h = s;
        ad = (ADHero) h; //此处抛出错误,Support类无法强制转换成ADHero类
    }
}