package charactor1;

public interface AD {
    public void physicAttack(); 

    default public void attack(){
        System.out.println("发起物理进攻");
    }
}