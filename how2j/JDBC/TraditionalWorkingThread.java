package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TraditionalWorkingThread extends Thread{
    public void run(){
        try{
            String drive = "com.mysql.cj.jdbc.Driver";
            Class.forName(drive);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); PreparedStatement ps = c.prepareStatement(sql);){
            for(int i=0; i<TestConnectionPool2.insertTime; i++){
                ps.setString(1, "Á÷ÀË½£¿Í");
                ps.setFloat(2, 345.8f);
                ps.setInt(3, 657);
                ps.execute();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}