package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMetaData {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("驱动初始化成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword);){
            //查看数据库层面的元数据
            //即数据库服务器版本,驱动版本,都有哪些数据库等等

            DatabaseMetaData dbmd = c.getMetaData();
            //获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t" + dbmd.getDatabaseProductName());
            //获取数据库服务器产品版本号
            System.out.println("数据库产品版本号:\t" + dbmd.getDatabaseProductVersion());
            //获取数据库服务器用作类别和表名之间的的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t" + dbmd.getCatalogSeparator());
            //获取驱动版本
            System.out.println("驱动版本:\t" + dbmd.getDriverVersion());

            System.out.println("可用的数据库列表");
            //获取数据库名称
            ResultSet rs = dbmd.getCatalogs();

            while(rs.next()){
                System.out.println("数据库名称:\t" + rs.getString(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}