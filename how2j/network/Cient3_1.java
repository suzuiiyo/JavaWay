package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cient3_1 {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dos.writeUTF(str);
            dos.close();
            s.close();
            sc.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}