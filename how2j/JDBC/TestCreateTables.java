package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateTables {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("������ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String upassword = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, username, upassword); Statement s = c.createStatement();)
        {
            /*String sql = "CREATE TABLE user (id int(11) PRIMARY KEY AUTO_INCREMENT," + "name varchar(30), " + "password varchar(30) );";
            int talk = s.executeUpdate(sql);
            if(talk == 0){
                System.out.println("���Ѿ������ɹ�");
            }*/
            //String sql2 = "insert into user values(null," +  "'dashen'"+"," +"'thisispassword');";
            /*String sql3 = "insert into user values(null," +  "'ookami'"+"," +"'blcaklivesmatter');";
            s.execute(sql3);
            System.out.println("�������ݳɹ���");
            String sql4 = "update user set password='blacklivesmatter'";
            s.execute(sql4);
            System.out.println("�޸����ݳɹ���");*/
            /*String sql5 = "delete from user where id in (3,4,5,6);";
            s.execute(sql5);
            System.out.println("ɾ�����ݳɹ�");
            String sql6 = "update user set password='thisispassword' where id=1;";
            s.execute(sql6);
            System.out.println("�޸����ݳɹ�");*/
            String name="dashen";
            //��ȷ�������ǣ�thisispassword
            String password="thisispassword1";
            //String sql = "select * from user where name='" + name + "' and password='" + password + "'";
            String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                System.out.println("�˺�������ȷ");
            }else{
                System.out.println("�˺��������");
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }
    }
}