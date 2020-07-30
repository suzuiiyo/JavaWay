package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private String drive = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/andriod";
    private String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
    private String user = "root";
    private String upassword = "admin";

    public Connection getCon() {
        Connection con = null;
        try{
            Class.forName(drive);
            con = DriverManager.getConnection(url+factor, user, upassword);
        }catch(Exception e){
            e.printStackTrace();
        }
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
            System.out.println("�����������ݿ�,���ӳɹ�");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("�����������ݿ�,����ʧ��");
        }
    }
}