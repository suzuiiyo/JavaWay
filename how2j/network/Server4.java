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
            System.out.println("监听在端口:8888");
            Socket s = ss.accept();

            Socket s1 = new Socket("127.0.0.1", 8888);

            InputStream is= s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String msgCli = dis.readUTF();
            System.out.println("收到客户端的信息" + msgCli);

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dos.writeUTF(str);
            s1.close();
            sc.close();
            ss.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    
}