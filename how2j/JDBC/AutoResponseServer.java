
package jdbc;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class AutoResponseServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("�����ڶ˿�:8888");
            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            DataInputStream dos = new DataInputStream(is);
            dos.readUTF();

            s.close();
            ss.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        //TODO  ��ѯ���ݿ�andriod�ҵ���Ӧ��response
    }
}