package hutubill.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String timezone = "UTC";
    static String LoginName = "root";
    static String password = "admin";

    // ������ʼ�����ھ�̬�������,��Ϊ���д�����Ҫ��ִ�У�����ֻ��Ҫִ��һ�ξ��㹻��
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=%s", ip, port,
                database, encoding, timezone);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, LoginName, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
}