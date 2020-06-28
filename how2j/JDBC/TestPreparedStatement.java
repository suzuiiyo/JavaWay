package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("驱动初始化成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s= c.createStatement(); PreparedStatement ps = c.prepareStatement(sql)){
            //Statement需要进行字符串拼接,可读性呵维护性比较差
            String sql0 = "insert into hero values(null," + "'牛头'" + "," + 313.0f + "," +50 + ")";
            s.execute(sql0);
            System.out.println("插入数据完成");

            //PreparedStatement 使用参数设置,可读性好，不易犯错
            //"insert into hero values(null, ?, ?, ?)";
            ps.setString(1, "大牛");
            ps.setFloat(2, 313.0f);
            ps.setInt(3, 50);
            ps.execute();
            System.out.println("插入数据完成");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}