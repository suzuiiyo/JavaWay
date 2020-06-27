package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExcuteUpdate {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            String sqlInsert = "insert into hero values(null, '��ħ', 616, 100)";
            String sqlDelete = "delete from hero where id = 100";
            String sqlUpdate = "update hero set hp = 300 where id = 100";

            //��ͬ��:������ִ������, ɾ��, �޸�
            s.execute(sqlInsert);
            s.execute(sqlDelete);
            s.execute(sqlUpdate);
            System.out.println("sql���ִ�����");

            s.executeUpdate(sqlInsert);
            s.executeUpdate(sqlDelete);
            s.executeUpdate(sqlUpdate);
            System.out.println("sql���ִ�����");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}