package hutubill.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static String ip = "127.0.0.1";
    public static int port = 3306;
    public static String database = "hutubill";
    public static String encoding = "UTF-8";
    public static String timezone = "UTC";
    public static String LoginName = "root";
    public static String password = "admin";

    // 驱动初始化放在静态代码块里,因为这行代码需要先执行，而且只需要执行一次就足够了
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