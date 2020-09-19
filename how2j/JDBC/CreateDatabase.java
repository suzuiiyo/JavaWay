package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String database = "andriod";
        new CreateDatabase().getConn(database);
    }

    String url = "jdbc:mysql://localhost:3306/how2java";
    String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
    String newUrl = "jdbc:mysql://localhost:3306/";
    String uname = "root";
    String upassword = "admin";

    public Connection getConn(String database){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("���ݿ��ʼ���ɹ�.");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            String databaseSql = "create database " + database;
            String tableSql = "CREATE TABLE dictionary (id int(100) AUTO_INCREMENT," + "receive varchar(100)," + "response varchar(100)," + "PRIMARY KEY (id));";

            Connection conn = DriverManager.getConnection(url+factor, uname, upassword);
            Statement smt = conn.createStatement();
            if(conn != null){
                System.out.println("���ݿ����ӳɹ�!");
                smt.executeUpdate(databaseSql);
                Connection newConn = DriverManager.getConnection(newUrl+database+factor, uname, upassword);
                if(newConn != null){
                    System.out.println("�Ѿ����ӵ��´��������ݿ�: " + database);

                    Statement newSmt = newConn.createStatement();
                    int i = newSmt.executeUpdate(tableSql);
                    if(i==0){
                        System.out.println(tableSql + "\n���Ѿ������ɹ�!");
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}