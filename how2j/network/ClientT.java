package network;

import java.io.IOException;
import java.net.Socket;

public class ClientT {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);

            //����������Ϣ�߳�
            new SendThread(s).start();
            //����������Ϣ�߳�
            new ReceiveThread(s).start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}