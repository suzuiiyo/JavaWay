package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnectionPool {
    public static void main(String[] args) {
        ConnectionPool con = new ConnectionPool(3);
        for(int i=0; i<100; i++){
            Thread t1 = new Thread(){
                public void run(){
                    Connection c = con.getConnection();
                    String sql = "insert into hero values(null, ?, ?, ?)";
                    try(PreparedStatement ps = c.prepareStatement(sql);){
                        //ģ��ʱ��1������ݿ�SQL���
                        Thread.sleep(1000);
                        System.out.println("��ȡ��һ�����ӣ�����ʼ����");
                        ps.setString(1, "ţ��");
                        ps.setFloat(2, (float)Math.random()*1000);
                        ps.setInt(3, (int)Math.random()*1000);
                        ps.execute();
                        con.returnConnection(c);
                    }catch(SQLException e){
                        e.printStackTrace();
                    }catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
        }
    }
}