package network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try{
            //���ӵ�������8888�˿�
            Socket s = new Socket("127.0.0.1", 8888);
            System.out.println(s);
            s.close();
            //��8888�˿��ϼ���,���Ƿ���
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}