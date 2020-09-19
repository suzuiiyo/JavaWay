package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPerformance {
    public static void main(String[] args) {
        HeroDAO dao = new HeroDAO();
        long tt1 = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            Thread t1 = new Thread(){
                public void run(){
                    String sql = "insert into hero values(null, ?, ?, ?)";
                    try(Connection c = dao.getConnection(); PreparedStatement ps = c.prepareStatement(sql);){
                        ps.setString(1, "????");
                        ps.setFloat(2, (float)Math.random()*1000);
                        ps.setInt(3, (int)Math.random()*1000);
                        ps.execute();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
        }
        long tt2 = System.currentTimeMillis();
        System.out.println("¡Á????¡À:" + (tt2-tt1));
    }
}