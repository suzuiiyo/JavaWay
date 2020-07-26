package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import file.ByteArrayToCharArray;

public class Server2 {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();

            //打开输入流
            InputStream is = s.getInputStream();

            //读取客户端发送的数据
            //int msg = is.read();
            byte[] b = new byte[20];
            is.read(b);
            char[] ch = ByteArrayToCharArray.read(b);
            
            //打印出来
            System.out.println(String.valueOf(ch));
            is.close();
            
            s.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}