package gui;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFrame;

public class LastLocationThread extends Thread {
    private JFrame f;
    File file = new File("d:/Studio/JavaWay/AC/DC/location.txt");

    LastLocationThread(JFrame f){
        this.f = f;
    }

    public void run(){
        while(true){
            int x = f.getX();
            int y = f.getY();
            try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
                dos.writeInt(x);
                dos.writeInt(y);
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}