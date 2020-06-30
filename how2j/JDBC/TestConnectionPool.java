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
                        //模拟时耗1秒的数据库SQL语句
                        Thread.sleep(1000);
                        System.out.println("获取到一个连接，并开始工作");
                        ps.setString(1, "牛酋");
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