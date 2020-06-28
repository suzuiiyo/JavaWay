package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPageQuery {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(drive);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("驱动加载成功");

        list(0,5);
        list(5,5);
        list(10,5);
        list(15,5);
    }

    public static void list(int start, int count){
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement();){
            String sql = "select * from hero limit " + start + "," + count;
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                float hp = rs.getFloat(3);
                int damage = rs.getInt("damage");
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}