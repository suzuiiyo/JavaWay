package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class TestJDBC3del {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC", "root", "admin");
            //ע�⣺ʹ�õ���java.sql.Statement
            //��Ҫ��С��ʹ�õ�: com.mysql.jdbc.Statement;
            s = c.createStatement();
            System.out.println("��ȡStatment����: " + s);

            //׼��sql���
            //ע��:�ַ���Ҫ�õ�����
            //String sql = "insert into hero value(null, "+"'��Ů'"+", "+313.0f+", "+50+")";
            for(int i=20356; i<43200; i++){
                String sql = "delete from hero where id = " + i;
                s.execute(sql);
                System.out.println("ִ��ɾ�����ɹ�");
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
        //���ݿ��������������Դ,��ز���������,���ɹر����ݿ�ĺ�ϰ��
        //�ȹر�Statment
            if(s != null){
                try{
                    s.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            //��ر�Connection
            if(c != null){
                try{
                    c.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}