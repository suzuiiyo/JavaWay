package hutubill.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class BillAlter2 extends BillTable2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        String alterSql = "ALTER TABLE record ADD CONSTRAINT pk_config_id primary key (id);";
        String alterSql2 = "ALTER TABLE record change id id int AUTO_INCREMENT;";
        String alterSql3 = "ALTER TABLE record ADD CONSTRAINT afk_record_category FOREIGN KEY (cid) REFERENCES category (id);";
        try(Statement smt = conn.createStatement()){
            if(conn != null){
                /*System.out.println("已连接到数据库" + database);
                int i = smt.executeUpdate(alterSql);
                if(i==0){
                    System.out.println("添加约束条件,设置主键成功!");
                }

                int j = smt.executeUpdate(alterSql2);
                if(j==0){
                    System.out.println("添加约束条件，设置主键自增长成功!");
                }*/

                int k = smt.executeUpdate(alterSql3);
                if(k==0){
                    System.out.println("添加约束条件, 设置外键成功!");
                }
            }
        }
    }
}