package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSqlCount {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("���ݿ�������ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String name = "root";
        String upassword = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, name, upassword); Statement s = c.createStatement();){
            String sql ="select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            int total=0;
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("��hero�а��������ݹ���"+total+"��");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}