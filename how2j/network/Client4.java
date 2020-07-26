package network;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client4 {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dos.writeUTF(str);

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String msgSer = dis.readUTF();
            System.out.println("�յ�����˵���Ϣ" + msgSer);
            
            s.close();
            sc.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}