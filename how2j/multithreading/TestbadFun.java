package multithreading;

import charactor.Hero;

public class TestbadFun {
    public static void main(String[] args) {
        final Hero lina = new Hero();
        lina.name = "莉娜";
        lina.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    //因为减血更快,所以盖伦的血量迟早会到1
                    //使用while循环判断是否是1,如果是1就不停的循环
                    //直到加血线程回复了血量
                    while(lina.hp==1){
                        continue;
                    }
                    lina.hurt();
                    System.out.printf("t1为%s减血1点, 减少血后，%s的血量是%.0f%n", lina.name, lina.name, lina.hp);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                while(lina.hp<616){
                    lina.recover();
                    System.out.printf("t2为%s回血1点，增加血后，%s的血量是%.0f%n", lina.name, lina.name, lina.hp);
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}