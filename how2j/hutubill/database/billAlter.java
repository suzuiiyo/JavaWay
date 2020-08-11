package hutubill.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class billAlter extends billTable2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        String alterSql = "ALTER TABLE config add constraint pk_hutubill_id key (id);";
        String alterSql2 = "ALTER TABLE config change id id int AUTO_INCREMENT;";
        try(Statement smt = conn.createStatement()){
            if(conn != null){
                System.out.println("已连接到数据库" + database);
                int i = smt.executeUpdate(alterSql);
                if(i==0){
                    System.out.println("添加约束条件,设置主键成功!");
                }

                int j = smt.executeUpdate(alterSql2);
                if(j==0){
                    System.out.println("添加约束条件，设置主键自增长成功!");
                }
            }
        }
    }
}