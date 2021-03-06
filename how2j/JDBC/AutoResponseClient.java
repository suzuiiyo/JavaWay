package jdbc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AutoResponseClient {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要发送的消息");
            String msg = sc.nextLine();

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(msg);

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String msgRec = dis.readUTF();
            System.out.println("收到信息:" + msgRec);

            s.close();
            sc.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}