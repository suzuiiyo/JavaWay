package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement3 {
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
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            //假设name屎用户提交来的数据
            String name = "'牛头' OR 1=1";
            String sql0 ="select * from hero where name = " + name;
            //拼接出来的SQL语句就是
            //select * from hero where name = '牛头' OR 1=1
            //因为有OR 1-1，所以恒成立
            //那么就会把所有的英雄查出来，而并不只是牛头
            //如果Hero表里的数据都是海量的,比如几百万条,把这个表里的数据全部查出来
            //会让数据库负载变高,CPU100%,内存消耗光,响应变得极其缓慢
            System.out.println(sql0);

            ResultSet rs0 = s.executeQuery(sql0);       //查询
            while(rs0.next()){
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
            s.execute(sql0);            //查询所有, 没有任何输出
            //使用预编译Statement就可以杜绝SQL注入
            ps.setString(1, name);
            /*ResultSet rs = ps.executeQuery();
            //查不出数据出来             防止因为OR 1=1  导致所有的name都被取出来
            while(rs.next()){
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }*/
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}