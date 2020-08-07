package annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilChild extends DBUtil {
    public static Connection getConnection2() throws SQLException {
        JDBCConfig config = DBUtilChild.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port  = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();
        
        String url = String.format("jdbc:mysql://%s:%d/%s?charactorEncoding=%s&severTime=%s", ip, port, database, encoding, 
                timezone);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection c = getConnection2();
        System.out.println(c);
    }
}