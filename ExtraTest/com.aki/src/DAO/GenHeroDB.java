package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GenHeroDB {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
    private String user = "root";
    private String password = "admin";
    Connection conn = null;
    Connection newConn = null;

    public Connection getConn(String database, String newDatabase){
        try{
            Class.forName(driver);
            System.out.println("���ݿ��ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            String databaseSql = "create database " + newDatabase;
            String tableSql = "CREATE TABLE hero (id int(100) AUTO_INCREMENT," + "name varchar(100)," + "hp float(20, 4)," + "attack float(20,4)," + "PRIMARY KEY (id));";

            conn = DriverManager.getConnection(url + database + factor, user, password);
            Statement smt = conn.createStatement();
            if(null != conn){
                System.out.println("���ݿ����ӳɹ�!");
                smt.executeUpdate(databaseSql);
                newConn = DriverManager.getConnection(url + newDatabase + factor, user, password);
                if(null != newConn){
                    System.out.println("�����ӵ��µ����ݿ⣺" + newDatabase);
                    Statement smt2 = newConn.createStatement();
                    int i = smt2.executeUpdate(tableSql);
                    if(i==0){
                        System.out.println(tableSql + "\n���Ѿ������ɹ�");
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return newConn;
    }

    public static void main(String[] args) {
        String database = "andriod";
        String newDatabase = "hero";
        new GenHeroDB().getConn(database, newDatabase);
    }
}
