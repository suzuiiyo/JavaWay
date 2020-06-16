package multithreading;

import java.util.List;

public class CrackDiaryThread3 extends Thread {
    private boolean found = false;
    private List<String> passwords;

    public CrackDiaryThread3(List<String> passwords){
        this.passwords = passwords;
        this.setDaemon(true);  // �Ѽ���־������̣߳�����Ϊ�ػ��߳�
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
        System.out.println("��ٷ��������ɵ�������: " + password);
    }
}