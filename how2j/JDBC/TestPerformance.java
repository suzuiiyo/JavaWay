package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPerformance {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("驱动初始化成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            long t1 = System.currentTimeMillis();
            for(int i=0; i<10000; i++){
                float hp = (float)Math.random()*1000;
                int damage = (int)Math.random()*1000;
                String sql1 = "insert into hero set name=" + "'hero'" + ", " +"hp=" + hp + ", " + "damage=" + damage +";";
                s.execute(sql1);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("Statement插入10000条数据花费的时间" + (t2-t1));

            long t3 = System.currentTimeMillis();
            for(int i=0; i<10000; i++){
                float hp = (float)Math.random()*1000;
                int damage = (int)Math.random()*1000;
                ps.setString(1, "半人马酋长");
                ps.setFloat(2, hp);
                ps.setInt(3, damage);
                ps.execute();
            }
            long t4 = System.currentTimeMillis();
            System.out.println("PreparedStatement插入10000条数据花费的时间" + (t4-t3));
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}