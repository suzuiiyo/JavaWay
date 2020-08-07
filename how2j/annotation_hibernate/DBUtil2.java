package annotation_hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import annotation.JDBCConfig;

@JDBCConfig(ip = "127.0.0.1", database = "how2java", encoding = "utf-8", timezone = "UTC", loginName = "root", password = "admin")
public class DBUtil2 {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        JDBCConfig config = DBUtil2.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String timezone = config.timezone();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=%s", ip, port, database, encoding, timezone);
        return DriverManager.getConnection(url, loginName, password);
    }
    public static void main(String[] args) throws SQLException {
        Connection c = getConn();
        System.out.println(c);
    }
}