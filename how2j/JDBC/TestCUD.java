package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class TestCUD {
    public static void main(String[] args) {
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(mysqlDriver);
            System.out.println("数据库驱动加载成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner sca = new Scanner(System.in);
        System.out.println("请输入要执行的sql语句");
        String sql = sca.nextLine();
        execute(sql);
        sca.close();
    }

    public static void execute(String sql){
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, username, password); Statement s = c.createStatement();)
        {
            s.execute(sql);
            System.out.println("sql语句执行完毕");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }   
}