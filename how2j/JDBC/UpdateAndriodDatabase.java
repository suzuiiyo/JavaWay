package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAndriodDatabase {
    public static void main(String[] args) throws Exception {
        DbUtil dul = new DbUtil();
        Connection conn = dul.getCon();
        String sqlStr = "insert into dictionary values(null, ?, ?)";
        String[] receive = {"���", "���ʲô", "����Ŷ", "ͬ־", "����ؿ��"};
        String[] response = {"������", "�������Ұ�", "����, �����Ұ���������С��", "����p�¶�"};
        for(int i=0; i<4; i++){
            try(PreparedStatement ps = conn.prepareStatement(sqlStr)){
                ps.setString(1, receive[i]);
                ps.setString(2, response[i]);
                ps.execute();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}