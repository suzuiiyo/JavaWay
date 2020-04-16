public class Hero2{
    private String name;
    private float hp;
    private float Armor;
    private int moveSpeed;

    // 无参构造
    public Hero2() {
    }

    // 有参构造
    public Hero2(String Name, float hp, float armor, int MoveSpeed) {
        this.name = Name;
        this.hp = hp;
        this.Armor = armor;
        this.moveSpeed = MoveSpeed;
    }

    public void legedary() {
        System.out.println("超神了吗？");
    }
    
    public float getHp() {
        return this.hp;
    }
    public String getName(){
        return this.name;
    }

    public float recovery(float blood) {
        return this.getHp() + blood;
    }

    public static void main(String[] args) {
        Hero2 garen = new Hero2("盖伦", 200.342f, 70.0f, 350);
        System.out.println(garen.getName() + "当前血量为" + garen.getHp());
        System.out.println(garen.getName() + "当前速度为" + garen.moveSpeed + ",其当前护甲为" + garen.Armor);
        garen.legedary();
        System.out.println("调用回血后," + garen.getName() + "的当前血量为" + garen.recovery(100.f));
    }
}

