package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {
    public DictionaryDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Dictionary> query(String receive) {
        List<Dictionary> ds = new ArrayList<>();
        String sql = "select * from dictionary where receive = ?";

        DbUtil dbl = new DbUtil();
        Connection conn = dbl.getCon();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dictionary d = new Dictionary();     //new一个Dictionary对象
                int id = rs.getInt(1);
                String receStr = rs.getString("receive");
                String respStr = rs.getString("response");

                d.id = id;
                d.receive = receStr;
                d.response = respStr;
                ds.add(d);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ds;
    }
}