package multithreading;

import charactor.Hero;

public class TestSkill {
    public static void main(String[] args) throws InterruptedException {
        Hero lina = new Hero("����", 345, 45);
        Hero juggnant = new Hero("��ʥ", 4554, 53);
        while(!juggnant.isDead()){
            try{
                lina.bodongquan(juggnant);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}