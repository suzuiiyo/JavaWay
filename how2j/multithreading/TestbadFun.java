package multithreading;

import charactor.Hero;

public class TestbadFun {
    public static void main(String[] args) {
        final Hero lina = new Hero();
        lina.name = "����";
        lina.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    //��Ϊ��Ѫ����,���Ը��׵�Ѫ������ᵽ1
                    //ʹ��whileѭ���ж��Ƿ���1,�����1�Ͳ�ͣ��ѭ��
                    //ֱ����Ѫ�̻߳ظ���Ѫ��
                    while(lina.hp==1){
                        continue;
                    }
                    lina.hurt();
                    System.out.printf("t1Ϊ%s��Ѫ1��, ����Ѫ��%s��Ѫ����%.0f%n", lina.name, lina.name, lina.hp);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                while(lina.hp<616){
                    lina.recover();
                    System.out.printf("t2Ϊ%s��Ѫ1�㣬����Ѫ��%s��Ѫ����%.0f%n", lina.name, lina.name, lina.hp);
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