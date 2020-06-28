package jdbc;

public class HeroJDBC {
    private int id;
    private String name;
    private float hp;
    private int damage;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setHp(Float hp){
        this.hp = hp;
    }

    public Float getHp(){
        return this.hp;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }
    public String toString() {
        String toStr = "id:" + id + ", name:" + name + ", hp:" + hp + ", damage:" + damage;
        return toStr;
    }
}