package hutubill.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import annotation.JDBCConfig;

@JDBCConfig(ip = "127.0.0.1", database = "hutubill", encoding = "utf-8", timezone = "UTC", loginName = "root", password = "admin")
public class BillTable3 {
    static JDBCConfig config = BillTable2.class.getAnnotation(JDBCConfig.class);
    static String ip = config.ip();
    static int port = config.port();
    static String database = config.database();
    static String encoding = config.encoding();
    static String timezone = config.timezone();
    static String loginName = config.loginName();
    static String password = config.password();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?charactorEncoding=%s&serverTimezone=%s", ip, port, database, encoding, timezone);
        Connection conn = DriverManager.getConnection(url, loginName, password);
        return conn;
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        String tableSql = "CREATE TABLE record (id int," + "spend int," + "cid int," + "comment varchar(255)," + "date Date) DEFAULT CHARSET=utf8;";
        try(Statement smt = conn.createStatement()){
            if(conn != null){
                System.out.println("连接到数据库成功:" + database);
                int i = smt.executeUpdate(tableSql);
                if(i==0){
                    System.out.println(tableSql + "表已经创建成功!");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}