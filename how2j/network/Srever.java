package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Srever {
    public static void main(String[] args) {
        try{
            //����˴򿪶˿�8888
            ServerSocket ss = new ServerSocket(8888);

            //��8888�˿��ϼ���,���Ƿ��������������
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();

            System.out.println("�����ӹ���" + s);
            s.close();
            ss.close();
        }catch(IOException e){
            //TODO
            e.printStackTrace();
        }
    }
}