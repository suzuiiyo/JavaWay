package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("������ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s= c.createStatement(); PreparedStatement ps = c.prepareStatement(sql)){
            //Statement��Ҫ�����ַ���ƴ��,�ɶ��Ժ�ά���ԱȽϲ�
            String sql0 = "insert into hero values(null," + "'ţͷ'" + "," + 313.0f + "," +50 + ")";
            s.execute(sql0);
            System.out.println("�����������");

            //PreparedStatement ʹ�ò�������,�ɶ��Ժã����׷���
            //"insert into hero values(null, ?, ?, ?)";
            ps.setString(1, "��ţ");
            ps.setFloat(2, 313.0f);
            ps.setInt(3, 50);
            ps.execute();
            System.out.println("�����������");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}