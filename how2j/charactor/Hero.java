package charactor;
import charactor1.ADHero;
import charactor1.APHero;
import exception.EnemyHeroIsDeadException;

import java.io.Serializable;

import charactor1.ADAPHero;

public class Hero implements Serializable, Comparable<Hero>{
    private static final long serialVersionUID = 1L; 
    public String name;
    public float hp;
    public float damage;
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

    try {
        //Ϊ�˱�ʾ������Ҫʱ��,ÿ�ι�����ͣ1000����
        Thread.sleep(1000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    h.hp-=damage;
    System.out.format("%s ���ڹ��� %s, %s��Ѫ�����%.0f%n", name, h.name, h.name, h.hp);
    if(h.isDead())
        System.out.println(h.name + "���ˣ�");
}

public void bodongquan(Hero h) throws InterruptedException {
    int bodongDamage = 32;
    for(int count=1; count<4; count++){
        System.out.printf(name + "��%sʹ����%d������ȭ!%n", h, count);
        h.hp -= bodongDamage;
        Thread.sleep(1000);          //ÿһ����ͣһ��
        if(count==3){
            System.out.println("�ȴ�5����г���");
            Thread.sleep(5000);
            count=0;
            System.out.println("�������,���·��𲨶�ȭ\n");
        }
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

    public boolean isDead(){
        return 0>=hp?true:false;
    }

    public Hero(){}

    public Hero(String name){
        this.name = name;
    }

    public Hero(String name, float hp){
        this.name = name;
        this.hp = hp;
    }
    public Hero(String name, float hp, float damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
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

    public int compareTo(Hero anohero){
        if(damage >= anohero.damage)
            return 1;
        else
            return -1;
    }

    public boolean matched(){
        return this.hp>100 && this.damage<50;
    }

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
        //return String.format("[name:%s hp:%.0f]%n", name, hp);
        return String.format("[name:%s hp:%.0f damage:%.0f]%n", name, hp, damage);
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

