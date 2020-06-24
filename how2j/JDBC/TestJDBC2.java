package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC2 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");    //manual loading driver is deprected
            //���������ݿ��Connection����
            //������Ҫ�ṩ:
            //���ݿ������ڵ�ip:127.0.0.1(����)
            //���ݿ�Ķ˿ں�: 3306(mysqlר�ö˿ں�)
            //���ݿ����� how2java
            //���뷽ʽ UTF-8
            //�˺� 
            //���� 
            //mysql JDBC URL��ʽ    jdbc:mysql://[host:port],[host:port].../[database][?������1][=����ֵ1][&������2][=����ֵ2]...
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
            "root", "admin");
            System.out.println("���ӳɹ�,��ȡ���Ӷ���: " + c);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}