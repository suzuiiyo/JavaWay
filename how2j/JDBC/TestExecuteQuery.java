package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestExecuteQuery {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("������ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC", "root", "admin"); Statement s = c.createStatement();){
            String sql = "select * from hero";
            //ִ�в�ѯ���,���ѽ�������ظ�ResultSet
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");//����ʹ���ֶ���
                String name = rs.getString(2); //Ҳ����ʹ���ֶε�˳��
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            //��һ��Ҫ������ر�ResultSt����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
            //rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}