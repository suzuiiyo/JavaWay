package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAutoIncreaseId {
    public static void main(String[] args) {
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("数据库驱动初始化完成");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=utf-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s=c.createStatement(); 
        PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {
            ps.setString(1, "发条");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            if(rs.next()){
                id = rs.getInt(1);
            }
            System.out.println("刚插入的数据的id是:" + id);
            for(int i=id -1; i>0; i--){
                int targetId = i;
                ResultSet rs2 = s.executeQuery("select id from Hero where id = " + targetId);
                if(rs2.next()){
                    System.out.println("id=" + targetId + "的数据存在，删除该数据");
                    String deleteSQL = "delete from hero where id = " + targetId;
                    s.execute(deleteSQL);
                    break;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}