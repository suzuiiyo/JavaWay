package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    public static HeroJDBC get(int id) {
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
        String sql = "select * from hero where id =" + id;
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            ResultSet rs = s.executeQuery(sql);
            //因为id是唯一的，ResultSet最多只能有一条记录
            //所以使用if代替while
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

    public static void add(HeroJDBC h){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, h.getName());
            ps.setFloat(2, h.getHp());
            ps.setInt(3, h.getDamage());

            ps.execute();
        }catch(SQLException e){
            //TODO:something is wrong
            e.printStackTrace();
        }
    }

    public static void delete(HeroJDBC h){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "delete from hero where id = ?";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            ps.setInt(1, h.getId());       //对id为1的数据执行删除操作
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(HeroJDBC h){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "update hero set name=?, hp=?, damage=?  where id=?";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, h.getName());
            ps.setFloat(2, h.getHp());
            ps.setInt(3, h.getDamage());
            ps.setInt(4, h.getId());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<HeroJDBC> list(){
        List<HeroJDBC> heros = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        String sql = "select * from hero";
        try(Connection c = DriverManager.getConnection(url+factor, user, upassword); Statement s = c.createStatement(); PreparedStatement ps = c.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HeroJDBC hero = new HeroJDBC();
                int id = rs.getInt("id");
                String name = rs.getString(2);
                Float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.setId(id);
                hero.setName(name);
                hero.setHp(hp);
                hero.setDamage(damage);
                heros.add(hero);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return heros;
    }

    public static void main(String[] args) {
        HeroJDBC hero = new HeroJDBC();
        List<HeroJDBC> hs = new ArrayList<>();
        /*hero.name = "发条地精";
        hero.hp = 456.08f;
        hero.damage = 345;*/
        //add(hero);
        HeroJDBC hero2 = get(40368);
        hero2.setName("沙王");
        update(hero2);
        hs = list();
        System.out.println(get(1).getName());
        System.out.println(hs);
    }
}