package multithreading;

import charactor.Hero;

public class TestWaitAndNotify {
    public static void main(String[] args) {
        final Hero lina = new Hero();
        lina.name = "¿Úƒ»";
        lina.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    //Œﬁ–Ë—≠ª∑≈–∂œ
                    //while(lina.hp==1)
                    //continue;
                //}
                    lina.hurt();
                
                    try{
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    lina.recover();
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}