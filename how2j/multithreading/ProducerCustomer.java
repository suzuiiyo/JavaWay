package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import collection.MyStack2;

public class ProducerCustomer {
    public static void main(String[] args) {
        MyStack2<Character> stc = new MyStack2<Character>();
        List<Character> list = new ArrayList<Character>();

        Thread producer = new Thread(){
            public void run(){
                while(true){
                    for(int i=0; i<100; i++){
                        Random r = new Random();
                        list.add((char)(r.nextInt(90-65)+65));
                        stc.push(list.get(i));
                        System.out.println(this.getName() + "Ñ¹Èë: " + list.get(i));
                    }
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        //producer.start();

        Thread customer = new Thread(){
            public void run(){
                while(true){
                    stc.pull();
                    System.out.println(this.getName() + "µ¯³ö: " + stc.pull());
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        //customer.start();

        Thread test = new Thread(){
            public void run(){
                //Thread producer1 = new Thread(producer);
                //producer1.start();
                Thread producer2 = new Thread(producer);
                producer2.start();
                //Thread customer1 = new Thread(customer);
                //customer1.start();
                Thread customer2 = new Thread(customer);
                customer2.start();
                //Thread customer3 = new Thread(customer);
                //customer3.start();
            }
        };
        test.start();
    }
}