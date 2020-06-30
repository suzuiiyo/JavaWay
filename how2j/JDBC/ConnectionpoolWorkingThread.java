package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionpoolWorkingThread extends Thread{
    private ConnectionPool cp;

    public ConnectionpoolWorkingThread(ConnectionPool cp){
        this.cp = cp;
    }

    public void run(){
        Connection c = cp.getConnection();
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(PreparedStatement ps = c.prepareStatement(sql)){
            for(int i=0; i<TestConnectionPool2.insertTime; i++){
                ps.setString(1, "ÌìÑÄÄ«¿Í");
                ps.setFloat(2, (float)Math.random()*1000);
                ps.setInt(3, (int)(Math.random()*1000));
                ps.execute();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}