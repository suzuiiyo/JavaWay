package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import file.ByteArrayToCharArray;

public class Server2 {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();

            //��������
            InputStream is = s.getInputStream();

            //��ȡ�ͻ��˷��͵�����
            //int msg = is.read();
            byte[] b = new byte[20];
            is.read(b);
            char[] ch = ByteArrayToCharArray.read(b);
            
            //��ӡ����
            System.out.println(String.valueOf(ch));
            is.close();
            
            s.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}