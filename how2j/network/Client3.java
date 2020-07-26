package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client3 {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();

            //���������װ��DataOutputStream��
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("����ţ��");
            dos.close();
            s.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}