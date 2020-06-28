package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatement3 {
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
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            //����nameʺ�û��ύ��������
            String name = "'ţͷ' OR 1=1";
            String sql0 ="select * from hero where name = " + name;
            //ƴ�ӳ�����SQL������
            //select * from hero where name = 'ţͷ' OR 1=1
            //��Ϊ��OR 1-1�����Ժ����
            //��ô�ͻ�����е�Ӣ�۲������������ֻ��ţͷ
            //���Hero��������ݶ��Ǻ�����,���缸������,��������������ȫ�������
            //�������ݿ⸺�ر��,CPU100%,�ڴ����Ĺ�,��Ӧ��ü��仺��
            System.out.println(sql0);

            ResultSet rs0 = s.executeQuery(sql0);       //��ѯ
            while(rs0.next()){
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
            s.execute(sql0);            //��ѯ����, û���κ����
            //ʹ��Ԥ����Statement�Ϳ��Զž�SQLע��
            ps.setString(1, name);
            /*ResultSet rs = ps.executeQuery();
            //�鲻�����ݳ���             ��ֹ��ΪOR 1=1  �������е�name����ȡ����
            while(rs.next()){
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }*/
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}