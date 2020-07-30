package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAndriodDatabase {
    public static void main(String[] args) throws Exception {
        DbUtil dul = new DbUtil();
        Connection conn = dul.getCon();
        String sqlStr = "insert into dictionary values(null, ?, ?)";
        String[] receive = {"你好", "你叫什么", "打你哦", "同志", "你做乜啊", "123"};
        String[] response = {"好你妹", "你想泡我啊", "来啊, 来打我啊，不打是小狗", "达瓦里希", "关你p事额", "机器人"};
        for(int i=0; i<6; i++){
            try(PreparedStatement ps = conn.prepareStatement(sqlStr)){
                ps.setString(1, receive[i]);
                ps.setString(2, response[i]);
                ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}