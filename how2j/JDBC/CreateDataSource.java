package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateDataSource {
    public static void main(String[] args) {
        String database = "demo";
        new CreateDataSource().getConn(database);
    }

    String drive = "com.mysql.cj.jdbc.Driver";
    String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
    String url = "jdbc:mysql://localhost:3306/how2java";
    String newUrl = "jdbc:mysql://localhost:3306/";
    String uname = "root";
    String upassword = "admin";
    Connection conn = null;
    Connection newConn = null;

    public Connection getConn(String database){
        try{
            Class.forName(drive);
            System.out.println("初始化数据仓库成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            String tableSql = "create table t_user (username varchar(50) not null primary key," + "password varchar(20) not null);";
            String databaseSql = "create database " + database;

            conn = DriverManager.getConnection(url+factor, uname, upassword);
            Statement smt = conn.createStatement();
            if(conn != null){
                System.out.println("数据库连接成功!");
                smt.executeUpdate(databaseSql);
                newConn = DriverManager.getConnection(newUrl+database+factor, uname, upassword);

                if(newConn != null){
                    System.out.println("已经连接到新创建的数据库: " + database);

                    Statement newSmt = newConn.createStatement();
                    int i = newSmt.executeUpdate(tableSql);          //DDL语句返回值为0;
                    if(i==0){
                        System.out.println(tableSql + "\n表已经创建成功!");
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}