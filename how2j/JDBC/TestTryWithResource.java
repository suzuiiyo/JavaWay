package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTryWithResource {
    //Connection c = null;
    //Statement s = null;
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?chacracterEncoding=UTF-8&serverTimezone=UTC", "root", "admin"); Statement s = c.createStatement();)
        {
            for(int i=7; i<30; i++){
                float hp = (float)Math.random()*1000;
                float damage = (float)Math.random()*1000;
                String sql = "insert into hero values(" + i +", " + "'巫医'" + "," + hp + "," + damage + ")";
                s.execute(sql);
                System.out.println("第" + (i-5) +"次插入成功！");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}