package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnumCrackThread {
    public static void main(String[] args) {
        Random r = new Random();
        List<String> passList = new ArrayList<>();
        StringBuffer passwd = new StringBuffer(String.valueOf((char)(r.nextInt(122-48)+48)));       //��������Ϊ3������ַ���
        for(int i=0; i<2; i++){
            passwd.append(String.valueOf((char)(r.nextInt(122-48)+48)));
        }
        System.out.println("������: " + passwd);
        System.out.println("\n ****************** \n");

        Thread crackThread = new Thread(){
            public void run(){
                String passwd2 = new String(passwd);            //passwd����ΪString  ����ط��޷���final����
                char[] ch = new char[3];
                boolean flag = true;
                while(flag){
                    for(int i=0; i<ch.length; i++){
                        ch[i] = (char)(r.nextInt(122-48)+48);
                    }
                    String passStr = String.valueOf(ch);
                    passList.add(passStr);
                    if(passStr.equals(passwd2)) {
                        System.out.println("������" + passStr + ",�ƽ�ɹ�!");
                        flag = false;                           //����whileѭ��
                    }
                }
            }
        };
        crackThread.start();
        System.out.println("\n ************************\n");
        System.out.println("������:" + passList.size() + "��");     //��ʾpassList.size()��ֵΪ0,���������õ��ⲿ�����޷����ظ��ⲿ��

        /*Thread diaryThread = new Thread(){
            public void run(){
                if(!passList.isEmpty()){
                    for(int i=0; i<passList.size(); i++){                 //��Ϊ����Ϊ�ػ��߳���,��������ӡ���������̾ͽ�����
                        System.out.println(passList.get(i));
                    }
                    System.out.println("������:" + passList.size() + "��" + ",�����ǣ�" + passList.get(passList.size()));
                }else{
                    try{
                        Thread.sleep(5000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        diaryThread.setDaemon(true);
        diaryThread.start();*/
    }
}