package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPerformance2 {
    public static void main(String[] args) {
        long tt1 = System.currentTimeMillis();
        ConnectionPool conPool = new ConnectionPool(10);
        Connection c = conPool.getConnection();
        String sql = "insert into hero values(null, ?, ?, ?)";
        for(int i=0; i<100; i++){
            Thread t1 = new Thread(){
                public void run(){
                    try(PreparedStatement ps = c.prepareStatement(sql);){
                        ps.setString(1, "¸«Íõ");
                        ps.setFloat(2, (float)Math.random()*1000);
                        ps.setInt(3, (int)Math.random()*1000);
                        ps.execute();
                    }catch(SQLException e){
                        e.printStackTrace();
                    };
                }
            };
            t1.start();
        }
        long tt2 = System.currentTimeMillis();
        System.out.println("×ÜºÄÊ±:" + (tt2-tt1));
    }
}