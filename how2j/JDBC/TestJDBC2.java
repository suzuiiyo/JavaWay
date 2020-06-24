package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC2 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");    //manual loading driver is deprected
            //建立与数据库的Connection连接
            //这里需要提供:
            //数据库所处于的ip:127.0.0.1(本机)
            //数据库的端口号: 3306(mysql专用端口号)
            //数据库名称 how2java
            //编码方式 UTF-8
            //账号 
            //密码 
            //mysql JDBC URL格式    jdbc:mysql://[host:port],[host:port].../[database][?参数名1][=参数值1][&参数名2][=参数值2]...
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
            "root", "admin");
            System.out.println("连接成功,获取连接对象: " + c);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}