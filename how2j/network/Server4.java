package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server4 {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("�����ڶ˿�:8888");
            Socket s = ss.accept();

            Socket s1 = new Socket("127.0.0.1", 8888);

            InputStream is= s.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            while(true){
                Scanner sc = new Scanner(System.in);
                System.out.println("������Ҫ���͸��ͻ��˵���Ϣ:");
                String str = sc.nextLine();
                dos.writeUTF(str);

                String msgCli = dis.readUTF();
                System.out.println("�յ��ͻ��˵���Ϣ" + msgCli + "\n");
            }
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}