package charactor;
public class Hero{
    protected String name;
    protected float hp;
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


    public static void main(String[] args){
        Hero garen = new Hero();
        garen.name = "¸ÇÂ×";
        garen.hp = 616.28f;
        garen.armor = 27.536f;
        garen.moveSpeed = 350;

        Hero teemo = new Hero();
        teemo.setName("ÌáÄª");
        teemo.hp = 383f;
        teemo.armor = 14f;
        teemo.moveSpeed = 330;

        Hero fatiao = new Hero();
        fatiao.name = "·¢Ìõ";
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
    }
    public Hero(){}

    public Hero(String name, float hp){
        this.name = name;
        this.hp = hp;
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
}

