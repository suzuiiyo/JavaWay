package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

public class HeroDAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String database = "how2java";
    private String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
    private String user = "root";
    private String password = "admin";

    public HeroDAO(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url + database + factor, user, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public int getTotal(){
        int total = 0;
        String sql = "select count(*) from hero";
        try(Connection conn = getConn(); Statement s = conn.createStatement()){
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public void add(Hero hero){
        String sql = "insert into hero values(null, ?, ?, ?)";
        //TODO  取自增id，要加Statement.RETURN_GENERATED_KEYS
        try(Connection conn = getConn(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setFloat(3, hero.getAttack());

            ps.execute();

            //立即取出插入的id值
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                hero.id = id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "delete from hero where id = " + id;
        try(Connection conn = getConn(); Statement s = conn.createStatement()){
            s.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Hero hero){
        String sql = "update hero set name = ?, hp =?, attack= ? where id = ?";
        try(Connection conn = getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setFloat(3, hero.getAttack());
            ps.setInt(4, hero.getId());

            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Hero get(int id){
        Hero hero = null;
        String sql = "select * from hero where id = " + id;
        try(Connection conn = getConn(); Statement s = conn.createStatement();){
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                hero = new Hero();
                String name = rs.getString("name");
                float hp = rs.getFloat(3);
                float attack = rs.getFloat(4);

                hero.setName(name);
                hero.setHp(hp);
                hero.setAttack(attack);
                hero.id = id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hero;
    }

    public List<Hero> list(){
        return list(0, Short.MAX_VALUE);
    }

    public List<Hero> list(int start, int count){
        List<Hero> heros = new ArrayList<>();
        String sql = "select * from hero order by id desc limit ?,? ";
        try(Connection conn = getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Hero hero = new Hero();
                int id = rs.getInt("id");
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                float attack = rs.getFloat(4);

                hero.setName(name);
                hero.setHp(hp);
                hero.setAttack(attack);
                hero.id=id;

                heros.add(hero);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return heros;
    }
}
