package charactor1;

public interface AP {
    public void magicAttack();

    default public void attack(){
        System.out.println("·¢ÆðÄ§·¨¹¥»÷");
    }
}