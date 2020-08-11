package annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(ip = "127.0.0.1", database="how2java", encoding="utf-8", timezone="UTC", loginName="root", password="admin")
public class DBUtilChild extends DBUtil {
    public static Connection getConnection2() throws SQLException {
        JDBCConfig config = DBUtilChild.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port  = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String timezone = config.timezone();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?charactorEncoding=%s&serverTimezone=%s", ip, port, database, encoding, 
                timezone);
        System.out.println(url);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection2());
    }
}