package hutubill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hutubill.database.DBUtil;
import hutubill.database.DateUtil;
import hutubill.entity.Record;

public class RecordDAO {
    public int getTotal(){
        int total = 0;
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement()){
            String sql = "select count(*) from record";
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

    public void add(Record record){
        String sql = "insert into record values(null, ?, ?, ?, ?)";

        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, record.getSpend());
            ps.setInt(2, record.getCid());
            ps.setString(3, record.getComment());
            ps.setDate(4, new java.sql.Date(record.getDate().getTime()));
            ps.execute();

            //TODO   操作，增加一个对象到数据库后将它的id取出来，以备后用
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                int id = rs.getInt(1);
                record.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Record record){
        String sql = "update record set Spend = ?, Cid = ?, Comment = ? Date = ? where id = ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, record.getComment());
            ps.setInt(2, record.getCid());
            ps.setString(3, record.getComment());
            ps.setDate(4, new java.sql.Date(record.getDate().getTime()));
            ps.setInt(5, record.getId());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement()){
            String sql = "delete from record where id = " + id;
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Record get(int id){
        Record record = null;
        try(Connection conn = DBUtil.getConn(); Statement s = conn.createStatement()){
            String sql = "select * from record where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                record = new Record();
                int spend = rs.getInt(1);
                int cid = rs.getInt(2);
                String comment = rs.getString(3);
                Date date = rs.getDate("date");

                record.setId(id);
                record.setComment(comment);
                record.setCid(cid);
                record.setDate(date);
                record.setSpend(spend);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return record;
    }

    public List<Record> list(){
        return list(0, Short.MAX_VALUE);
    }
    //分页查询
    public List<Record> list(int start, int count){
        List<Record> records = new ArrayList<>();
        String sql = "select * from record order by id desc limit ?, ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Record record = new Record();
                int id = rs.getInt(1);
                String comment = rs.getString(2);
                int cid = rs.getInt("cid");
                Date date = rs.getDate(5);
                int spend = rs.getInt("spend");

                record.setId(id);
                record.setCid(cid);
                record.setComment(comment);
                record.setSpend(spend);
                record.setDate(date);

                records.add(record);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return records;
    }

    public List<Record> list(int cid){
        List<Record> records = new ArrayList<>();
        String sql = "select * from record where cid = ？";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Record record = new Record();
                int id = rs.getInt(1);
                int spend = rs.getInt("spend");
                String commment = rs.getString("comment");
                Date date = rs.getDate(5);

                record.setId(id);
                record.setSpend(spend);
                record.setComment(commment);
                record.setDate(date);
                record.setCid(cid);

                records.add(record);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return records;

    }

    public Record getByCid(int cid){
        Record record = null;
        String sql = "select * from record where cid = ？";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                record = new Record();
                int id = rs.getInt(1);
                int spend = rs.getInt("spend");
                String commment = rs.getString("comment");
                Date date = rs.getDate(5);

                record.setId(id);
                record.setSpend(spend);
                record.setComment(commment);
                record.setDate(date);
                record.setCid(cid);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return record;
    }

    //获取今天的消费记录信息
    public List<Record> listToday(){
        return list(DateUtil.today());
    }

    //获取某天的消费记录信息
    public List<Record> list(Date day){
        List<Record> records = new ArrayList<>();
        String sql = "select * from record where date = ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDate(1, new java.sql.Date(day.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Record record = new Record();
                int id = rs.getInt(1);
                int spend = rs.getInt(2);
                int cid = rs.getInt(3);
                String comment = rs.getString(4);
                Date date = rs.getDate(5);

                record.setId(id);
                record.setSpend(spend);
                record.setCid(cid);
                record.setComment(comment);
                record.setDate(date);

                records.add(record);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return records;
    }

    //获取本月的消费记录信息
    public List<Record> listThisMonth(){
        return list(DateUtil.monthBegin(), DateUtil.monthEnd());
    }

    //获取某个时间范围内的消费记录信息
    public List<Record> list(Date start, Date end){
        List<Record> records = new ArrayList<>();
        String sql = "select * from record where date >= ? adn date <= ?";
        try(Connection conn = DBUtil.getConn(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDate(1, new java.sql.Date(start.getTime()));
            ps.setDate(2, new java.sql.Date(end.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Record record = new Record();
                int id = rs.getInt(1);
                int spend = rs.getInt(2);
                int cid = rs.getInt(3);
                String comment = rs.getString(4);
                Date date = rs.getDate(5);

                record.setId(id);
                record.setSpend(spend);
                record.setCid(cid);
                record.setComment(comment);
                record.setDate(date);

                records.add(record);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return records;
    }
}