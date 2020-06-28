package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement2 {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("�������سɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); PreparedStatement ps = c.prepareStatement(sql)){
            //Statementִ��10�Σ���Ҫ10�ΰ�SQL��䴫�䵽���ݿ��
            //���ݿ�Ҫ��ÿһ������SQL�����б��봦��
            for(int i=30; i<40; i++){
                String sql0 = "insert into hero values(null," + "'��˹'" + "," + 453.7f + "," + 67 + ")";
                s.execute(sql0);
                System.out.println("���ݲ���ɹ�");
            }

            //PreparedStatement ִ��10��, ֻ��Ҫ1�ΰ�SQL��䴫�䵽���ݿ��
            //���ݿ�Դ�����SQL����Ԥ����

            //ÿ��ִ��,ֻ��Ҫ������������ݿ��
            //1.���紫������Statement��С
            //2.���ݿⲻ��Ҫ�ڽ��б���,��Ӧ����
            for(int i=0; i<10; i++){
                ps.setString(1, "����");
                ps.setFloat(2, 313.7f);
                ps.setInt(3, 50);
                ps.execute();
                System.out.println("���ݲ���ɹ�");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}