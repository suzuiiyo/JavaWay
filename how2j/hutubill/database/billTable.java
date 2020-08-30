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
        //DBUtil没有使用注解, 这个地方用DBUtilChild解析注解
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
        //用DbUtil初始化并连接到how2java数据库
        //jdbc必须先进入到一个数据库,才能用sql语句新建一个数据库
        DbUtil db = new DbUtil();
        conn = db.getCon();
        String databaseSql = "create database hutubill";
        String tableSql = "CREATE TABLE category (id int(100) AUTO_INCREMENT," + "name varchar(100)," + "PRIMARY KEY (id));"; 

        try(Statement ps = conn.createStatement()){
            if(conn != null){
                System.out.println("数据库连接成功!");
                ps.executeUpdate(databaseSql);
                newConn = DriverManager.getConnection(url, loginName, password);
                if(newConn != null){
                    System.out.println("连接到创建的数据库成功:" + database);
                    
                    Statement newPs = newConn.createStatement();
                    int i = newPs.executeUpdate(tableSql);
                    if(i==0)
                        System.out.println(tableSql + "表已经创建成功!");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}