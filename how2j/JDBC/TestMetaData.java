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
            System.out.println("������ʼ���ɹ�");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword);){
            //�鿴���ݿ�����Ԫ����
            //�����ݿ�������汾,�����汾,������Щ���ݿ�ȵ�

            DatabaseMetaData dbmd = c.getMetaData();
            //��ȡ���ݿ��������Ʒ����
            System.out.println("���ݿ��Ʒ����:\t" + dbmd.getDatabaseProductName());
            //��ȡ���ݿ��������Ʒ�汾��
            System.out.println("���ݿ��Ʒ�汾��:\t" + dbmd.getDatabaseProductVersion());
            //��ȡ���ݿ�������������ͱ���֮��ĵķָ��� ��test.user
            System.out.println("���ݿ�ͱ�ָ���:\t" + dbmd.getCatalogSeparator());
            //��ȡ�����汾
            System.out.println("�����汾:\t" + dbmd.getDriverVersion());

            System.out.println("���õ����ݿ��б�");
            //��ȡ���ݿ�����
            ResultSet rs = dbmd.getCatalogs();

            while(rs.next()){
                System.out.println("���ݿ�����:\t" + rs.getString(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}