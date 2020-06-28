package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPageQuery2 {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("驱动初始化成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        list(0,5);
        list(5,5);
        /*list(10, 5);
        list(15, 5);*/
    }

    public static void list(int start, int count){
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            String sql0 = "select * from hero limit " + start + "," + count;
            boolean isQuery = s.execute(sql0);
            if(isQuery){
                ResultSet rs = s.getResultSet();      //s执行execute后  可以返回查询结果
                while(rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    Float hp = rs.getFloat(3);
                    int damage = rs.getInt(4);
                    System.out.printf("%d\t%s\t%f\t%d\n", id, name, hp, damage);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}