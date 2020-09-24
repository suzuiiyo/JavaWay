package bean;

public class Hero {
    public int id;
    private String name;
    private float hp;
    private float attack;
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

	public String getName() {
		return name;
    }
    
    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getHp() {
        return hp;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getAttack() {
        return attack;
    }

    @Override
    public String toString(){
        return "hero [name=" + name + ", hp=" + hp + "]";
    }
}