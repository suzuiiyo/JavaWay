package network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);

            //�������
            OutputStream os = s.getOutputStream();

            //��������110�������
            String str = "������ҷ�";
            byte[] b = str.getBytes("UTF-8");
            os.write(b);
            os.close();

            s.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}