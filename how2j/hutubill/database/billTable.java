package hutubill.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import annotation.JDBCConfig;
import jdbc.DbUtil;

@JDBCConfig(ip="127.0.0.1", database="hutubill", encoding="utf-8", timezone="UTC", loginName="root", password="admin")
public class BillTable {
    public static void main(String[] args) {
        //DBUtilû��ʹ��ע��, ����ط���DBUtilChild����ע��
        JDBCConfig config = BillTable.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String timezone = config.timezone();
        String loginName = config.loginName();
        String password = config.password();
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=%s", ip, port, database, encoding, timezone);

        Connection conn = null;
        Connection newConn = null;
        //��DbUtil��ʼ�������ӵ�how2java���ݿ�
        //jdbc�����Ƚ��뵽һ�����ݿ�,������sql����½�һ�����ݿ�
        DbUtil db = new DbUtil();
        conn = db.getCon();
        String databaseSql = "create database hutubill";
        String tableSql = "CREATE TABLE category (id int(100) AUTO_INCREMENT," + "name varchar(100)," + "PRIMARY KEY (id));"; 

        try(Statement ps = conn.createStatement()){
            if(conn != null){
                System.out.println("���ݿ����ӳɹ�!");
                ps.executeUpdate(databaseSql);
                newConn = DriverManager.getConnection(url, loginName, password);
                if(newConn != null){
                    System.out.println("���ӵ����������ݿ�ɹ�:" + database);
                    
                    Statement newPs = newConn.createStatement();
                    int i = newPs.executeUpdate(tableSql);
                    if(i==0)
                        System.out.println(tableSql + "���Ѿ������ɹ�!");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}