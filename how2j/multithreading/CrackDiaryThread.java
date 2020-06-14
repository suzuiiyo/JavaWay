package multithreading;

import java.util.List;

public class CrackDiaryThread extends Thread{
    private List<String> list;
    public CrackDiaryThread(List<String> list){
        this.setDaemon(true);               //本线程设为Daemon
        this.list = list;
    }
    public void run(){
        /*if(!list.isEmpty()){
            Iterator<String> ite = list.iterator();
            while(ite.hasNext()){
                System.out.println(ite.next());
            }
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
            System.out.printf("共尝试%d次，匹配密码为%s", list.size(), list.get(list.size()-1));
        }else{
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }*/
        while(true){
            while(list.isEmpty()){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            String passwd = list.remove(0);
            System.out.println("本次尝试的密码为: " + passwd);
        }
    }
}