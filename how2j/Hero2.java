public class Hero2{
    private String name;
    private float hp;
    private float Armor;
    private int moveSpeed;

    //无参构造
    public Hero2(){
    }
    
    //有参构造
    public Hero2(String name, float hp, float armor, int moveSpeed){
        this.name = name;
        this.hp = hp;
        Armor = armor;
        this.moveSpeed = moveSpeed;
        }

    public void legedary(){
        System.out.println("超神");
    }

    public float getHp(){
        return this.hp;
    }

    public float recovery(float blood){
        return this.getHp() + blood;
    }

    public static void main(String[] args) {
        Hero2 garen = new Hero2("盖伦", 200.342f, 70.0f, 350);
        System.out.println("当前血量：" + garen.getHp());
        garen.legedary();
        System.out.println("调用回血后：" + garen.recovery(100.f));
    }
}

