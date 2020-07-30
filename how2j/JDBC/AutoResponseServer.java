
package jdbc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoResponseServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("监听在端口:8888");
            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String msg = dis.readUTF();
            System.out.println("收到客户端信息:" + msg);

            DbUtil dbl = new DbUtil();
            Connection conn = dbl.getCon();
            String sqlStr = "select * from dictionary where receive = ?";
            PreparedStatement ps = conn.prepareStatement(sqlStr);
            if(conn != null){
                System.out.println("已连接到数据库");
                if(ps != null){
                    System.out.println("查询状态已建立");
                }
            }
            ps.setString(1, msg);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String respStr = rs.getString("response");
                System.out.println(respStr);
                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(respStr);
            }
            ss.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}