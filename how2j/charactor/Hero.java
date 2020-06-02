package charactor;
import charactor1.ADHero;
import charactor1.APHero;
import exception.EnemyHeroIsDeadException;

import java.io.Serializable;

import charactor1.ADAPHero;

public class Hero implements Serializable{
    private static final long serialVersionUID = 1L; 
    public String name;
    public float hp;
    float armor;
    int moveSpeed;
    int initGold;
    int numOfSongsi;
    int numOfKill;
    int numOfMoney;
    int numOfBudao;
    int paceOfattack;
    String wordsAfterkilled;
    String wordsAfterkilling;
    public String copyright;
    

public void setName(String name){
    this.name = name;
}
public String getName(){
    return name;
}
public void setHp(float hp){
    this.hp = hp;
}
public float getHp(){
    return hp;
}
public void kill(Mortal m){
    m.die();
}

public void attackHero(Hero h) throws EnemyHeroIsDeadException {
    System.out.println(this.name + "������" + h.name);
    if(h.hp == 0){
        throw new EnemyHeroIsDeadException(h.name + "���˽֣��޷���Ϊ����������");
    }
}

    public static void main(String[] args){
        Hero garen = new Hero();
        garen.name = "����";
        garen.hp = 616.28f;
        garen.armor = 27.65f;
        garen.moveSpeed = 350;

        Hero teemo = new Hero();
        teemo.setName("��Ī");
        teemo.hp = 0;
        teemo.armor = 14f;
        teemo.moveSpeed = 330;

        Hero fatiao = new Hero();
        fatiao.name = "����ħ��";
        fatiao.hp = 342.53f;
        fatiao.armor = 32.54f;
        fatiao.moveSpeed = 309;
        fatiao.initGold = 345;
        fatiao.numOfSongsi = 3;
        fatiao.numOfKill = 24;
        fatiao.numOfMoney = 542;
        fatiao.numOfBudao = 243;
        fatiao.paceOfattack = 211;
        fatiao.wordsAfterkilled = " how much is this?"; 
        fatiao.wordsAfterkilling = " what's wrong with you";

        System.out.println(teemo.name);
        System.out.println(teemo.getName());

        Hero juggnaut = new Hero();
        juggnaut.setName("��ʥ");
        ADHero DragonKnight = new ADHero();
        DragonKnight.setName("����ʿ");
        APHero Lion = new APHero();
        Lion.setName("����");
        ADAPHero QOP = new ADAPHero();
        QOP.setName("ʹ��Ů��");
        juggnaut.kill(DragonKnight);
        juggnaut.kill(Lion);
        juggnaut.kill(QOP);

        System.out.println(QOP.getName());

        try{
            garen.attackHero(teemo);
        }
        catch(EnemyHeroIsDeadException e){
            System.out.println("��ʾ�����쳣ԭ��: "); // + e.getMessage());
            e.printStackTrace();
        }
    }

    public Hero(){}

    public Hero(String name){
        this.name = name;
    }

    public Hero(String name, float hp){
        this.name = name;
        this.hp = hp;
    }

    public static void battleWin(){
        System.out.println("hero battle win");
    }
    /*public Hero(String heroName, float heroHP, float heroArmor, int heroMoveSpeed){
        name = heroName;
        hp = heroHP;
        armor = heroArmor;
        moveSpeed = heroMoveSpeed;
    }*/

    public Hero(String name, float hp, float armor, int moveSpeed){
        this(name, hp);
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.moveSpeed = moveSpeed;
    }

    //public abstract void attack(){
    //}
    public String toString(){    //��дtoString���������򷵻ع�ϣֵ
        //return name;
        return String.format("[name:%s hp:%.0f]%n", name, hp);
    }
    public String getClassName(){
        String className=null;
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] element=e.getStackTrace();
            className=element[0].getClassName();
        }
        return className;
    }
}

