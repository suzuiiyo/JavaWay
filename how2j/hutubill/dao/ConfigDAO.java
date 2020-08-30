package hutubill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hutubill.database.DBUtil;
import hutubill.entity.Config;

//ConfigDAO 专门用于把Config实例与Config表进行ORM映射
public class ConfigDAO {
    public int getTotal(){
        int total = 0;
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement();){
            String sql = "select count(*) from config";
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

    public void add(Config config){
        String sql = "insert into config values(null, ?, ?)";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, config.getKey_());
            ps.setString(2, config.getValue());
            ps.execute();
            //TODO  默认操作，增加一个对象到数据库后将它的Id取出来
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                config.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Config config){
        String sql = "update config set key_= ?, value = ? where id = ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, config.getKey_());
            ps.setString(2, config.getValue());
            ps.setInt(3, config.getId());

            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement()){
            String sql = "delete from config where id = " + id;
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Config get(int id){
        Config config = null;
        try(Connection conn = DBUtil.getConn(); Statement s  = conn.createStatement()){
            String sql = "select * from config where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                config = new Config();
                String key_ = rs.getString("key_");
                String value = rs.getString("value");
                config.setKey_(key_);
                config.setValue(value);
                config.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return config;
    }

    //查询所有,不分页
    public List<Config> list(){
        return list(0, Short.MAX_VALUE);
    }

    //分页查询
    public List<Config> list(int start, int count){
        List<Config> configs = new ArrayList<Config>();
        //根据id降序排列 ，最新添加的数据放在前面
        String sql = "select * from config order by id desc limit ?, ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Config config = new Config();
                int id = rs.getInt(1);
                String key_ = rs.getString("key_");
                String value = rs.getString("value");
                config.setId(id);
                config.setKey_(key_);
                config.setValue(value);

                configs.add(config);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return configs;
    }

    //通过键获取Config实例,比如预算对应的Config实例，就会通过这种方式获取：new ConfigDAO().getByKey("budget");
    public Config getByKey(String key){
        Config config = null;
        String sql = "select * from config where key_ = ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                config = new Config();
                int id = rs.getInt(1);
                String value = rs.getString("value");
                config.setId(id);
                config.setValue(value);
                config.setKey_(key);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return config;
    }
}