package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC4 {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("数据库驱动初始化完成");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); 
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, "卡尔");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);

            //执行插入语句
            ps.execute();

            //在执行完插入语句后,MySQL会为新插入的数据分配一个自增长id
            //JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                System.out.println(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}