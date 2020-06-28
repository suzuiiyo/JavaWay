package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestReturnObject {
    public static HeroJDBC get(int id){
        HeroJDBC hero = null;
        String drive = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(drive);
            System.out.println("驱动初始化成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement();){
            String sql = "select * from hero where id=" + id;
            ResultSet rs = s.executeQuery(sql);

            //因为id是唯一的，ResultSet最多只能有一条记录
            //所以使用if替代while
            if(rs.next()){
                hero = new HeroJDBC();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.setName(name);
                hero.setHp(hp);
                hero.setDamage(damage);
                hero.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hero;
    }

    public static void main(String[] args) {
        HeroJDBC h = get(22);
        System.out.println(h.getName());
    }
}