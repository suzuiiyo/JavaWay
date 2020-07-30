package network;

import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SendThread extends Thread{
    private Socket s;
    public SendThread(Socket s){
        this.s = s;
    }

    public void run(){
        try{
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            while(true){
                Scanner sc = new Scanner(System.in);
                String msg = sc.nextLine();
                dos.writeUTF(msg);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}