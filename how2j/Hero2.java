public class Hero2{
    private String name;
    private float hp;
    private float Armor;
    private int moveSpeed;

    // �޲ι���
    public Hero2() {
    }

    // �вι���
    public Hero2(String Name, float hp, float armor, int MoveSpeed) {
        this.name = Name;
        this.hp = hp;
        this.Armor = armor;
        this.moveSpeed = MoveSpeed;
    }

    public void legedary() {
        System.out.println("��������");
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
        Hero2 garen = new Hero2("����", 200.342f, 70.0f, 350);
        System.out.println(garen.getName() + "��ǰѪ��Ϊ" + garen.getHp());
        System.out.println(garen.getName() + "��ǰ�ٶ�Ϊ" + garen.moveSpeed + ",�䵱ǰ����Ϊ" + garen.Armor);
        garen.legedary();
        System.out.println("���û�Ѫ��," + garen.getName() + "�ĵ�ǰѪ��Ϊ" + garen.recovery(100.f));
    }
}

