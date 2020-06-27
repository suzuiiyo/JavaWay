package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExcuteUpdateDiff {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("������ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            //��ͬ1��execute����ִ�в�ѯ���
            //Ȼ��ͨ��getResultSet���ѽ����ȡ����
            String sqlSelect = "select * from hero";
            s.execute(sqlSelect);
            ResultSet rs = s.getResultSet();
            while(rs.next()){
                System.out.println(rs.getInt("id"));
            }

            //executeUpdate����ִ�в�ѯ���
            //s.executeUpdate(sqlSelect);

            //��ͬ2��
            //execute����boolean����,true��ʾִ�е��ǲ�ѯ���, false��ʾִ�е���:insert, delete, update�ȵ�
            boolean isSelect = s.execute(sqlSelect);
            System.out.println(isSelect);

            //executeUpdate���ص���Int, ��ʾ�ж��������ܵ���Ӱ��
            String sqlUpdate = "update hero set hp = 300 where id < 100";
            int number = s.executeUpdate(sqlUpdate);
            System.out.println(number);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}