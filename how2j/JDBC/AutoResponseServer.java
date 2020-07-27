
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
            System.out.println("监听在端口:8888");
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

        //TODO  查询数据库andriod找到相应的response
    }
}