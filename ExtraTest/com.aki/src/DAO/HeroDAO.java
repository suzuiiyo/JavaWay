package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HeroDAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String database = "hero";
    private String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
    private String user = "root";
    private String password = "admin";

    public HeroDAO(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConn(String database) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url + database + factor, user, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
