package multithreading;

import java.util.List;

public class CrackDiaryThread3 extends Thread {
    private boolean found = false;
    private List<String> passwords;

    public CrackDiaryThread3(List<String> passwords){
        this.passwords = passwords;
        this.setDaemon(true);  // 把记日志的这个线程，设置为守护线程
    }

    public void run(){
        while(found){
            while(passwords.isEmpty()){
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        String password = passwords.remove(0);
        System.out.println("穷举法本次生成的密码是: " + password);
    }
}