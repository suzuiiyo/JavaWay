package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExcuteUpdateDiff {
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
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            //不同1：execute可以执行查询语句
            //然后通过getResultSet，把结果集取出来
            String sqlSelect = "select * from hero";
            s.execute(sqlSelect);
            ResultSet rs = s.getResultSet();
            while(rs.next()){
                System.out.println(rs.getInt("id"));
            }

            //executeUpdate不能执行查询语句
            //s.executeUpdate(sqlSelect);

            //不同2：
            //execute返回boolean类型,true表示执行的是查询语句, false表示执行的是:insert, delete, update等等
            boolean isSelect = s.execute(sqlSelect);
            System.out.println(isSelect);

            //executeUpdate返回的是Int, 表示有多少数据受到了影响
            String sqlUpdate = "update hero set hp = 300 where id < 100";
            int number = s.executeUpdate(sqlUpdate);
            System.out.println(number);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}