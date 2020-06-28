package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement2 {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("驱动加载成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); PreparedStatement ps = c.prepareStatement(sql)){
            //Statement执行10次，需要10次把SQL语句传输到数据库端
            //数据库要对每一次来的SQL语句进行编译处理
            for(int i=30; i<40; i++){
                String sql0 = "insert into hero values(null," + "'宙斯'" + "," + 453.7f + "," + 67 + ")";
                s.execute(sql0);
                System.out.println("数据插入成功");
            }

            //PreparedStatement 执行10次, 只需要1次把SQL语句传输到数据库端
            //数据库对带？的SQL进行预编译

            //每次执行,只需要传输参数到数据库端
            //1.网络传输量比Statement更小
            //2.数据库不需要在进行编译,响应更快
            for(int i=0; i<10; i++){
                ps.setString(1, "雷神");
                ps.setFloat(2, 313.7f);
                ps.setInt(3, 50);
                ps.execute();
                System.out.println("数据插入成功");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}