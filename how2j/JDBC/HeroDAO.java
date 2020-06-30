package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO{
    public HeroDAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动初始化成功");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/how2java?chracterEncoding=UTF-8&serverTimezone=UTC", "root", "admin");
    }

    @Override
    public void add(HeroJDBC hero) {
        // TODO Auto-generated method stub
        String sql = "insert into hero(null, ?, ?, ?)";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ps.setString(1, hero.getName());
                ps.setFloat(2, hero.getHp());
                ps.setInt(3, hero.getDamage());
                ps.execute();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(HeroJDBC hero) {
        // TODO Auto-generated method stub
        String sql = "update hero set name = ?, hp =?, damage = ? where id = ?";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());
            ps.setInt(4, hero.getId());

            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        try(Connection c = getConnection(); Statement s = c.createStatement()){
            String sql = "delete from hero where id =" + id;
            s.execute(sql);    
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public HeroJDBC get(int id) {
        HeroJDBC hero = new HeroJDBC();
        // TODO Auto-generated method stub
        try(Connection c = getConnection(); Statement s = c.createStatement()){
            String sql = "select * from hero where id=" +id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                String name = rs.getString(1);
                Float hp = rs.getFloat(2);
                int damage = rs.getInt(3);
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

    public int getTotal(){
        int total = 0;
        try(Connection c = getConnection(); Statement s = c.createStatement()){
            String sql = "select count(*) from hero";
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
    
    public List<HeroJDBC> list(int start, int count){
        List<HeroJDBC> heros = new ArrayList<>();
        String sql = "select * from hero order by id desc limit ?,?";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, start);            //分页查询
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HeroJDBC hero = new HeroJDBC();
                int id = rs.getInt("id");
                String name = rs.getString(2);
                Float hp = rs.getFloat(3);
                int damage = rs.getInt("damage");
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

    @Override
    public List<HeroJDBC> list() {
        // TODO Auto-generated method stub
        return list(0, Short.MAX_VALUE);
    }
}