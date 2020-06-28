package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private String drive = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/how2java";
    private String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
    private String user = "root";
    private String upassword = "admin";

    public Connection getCon() throws Exception{
        Class.forName(drive);
        Connection con = DriverManager.getConnection(url+factor, user, upassword);
        return con;
    }

    public static void getClose(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        DbUtil db = new DbUtil();
        try{
            db.getCon();
            System.out.println("测试连接数据库,连接成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("测试连接数据库,连接失败");
        }
    }
}