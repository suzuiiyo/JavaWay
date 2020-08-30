package hutubill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hutubill.database.DBUtil;
import hutubill.entity.Category;

public class CategoryDAO {
    public int getRecordNumber(){
        int recordNumber = 0;
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement();){
            String sql = "select count(*) from config";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                recordNumber = rs.getInt(1);
            }
            System.out.println("total:" + recordNumber);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return recordNumber;
    }

    //TODO  mysql5.1.7版本之后的mysql-connector增加了返回GeneratedKeys的条件,如果需要返回GeneratedKeys,
    //TODO  则PreparedStatement需要显式添加一个参数Statement.RETURN_GENERATED_KEYS
    public void add(Category category){
        String sql = "insert into category values(null, ?)";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, category.getName());
            ps.execute();

            //默认操作，增加一个对象到数据库后将它的id取出来
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                category.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Category category){
        String sql = "update category set name = ? where id = ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement();){
            String sql = "delete from category where id = " + id;
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Category get(int id){
        Category category = null;
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement()){
            String sql = "select * from category where id =" + id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                category = new Category();
                String name = rs.getString("name");
                category.setId(id);
                category.setName(name);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    //全部查询
    public List<Category> list(){
        return list(0, Short.MAX_VALUE);
    }
    //分页查询
    public List<Category> list(int start, int count){
        List<Category> categorys = new ArrayList<>();
        String sql = "select * from category order by id desc limit ?, ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                int id = rs.getInt(1);
                String name = rs.getString("name");
                category.setId(id);
                category.setName(name);

                categorys.add(category);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return categorys;
    }

    public Category getByName(String name){
        Category category = null;
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement();){
            String sql = "select * from category where name =" + name;
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                category = new Category();
                int id = rs.getInt(1);
                category.setId(id);
                category.setName(name);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return category;
    }
}