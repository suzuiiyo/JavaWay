package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class TestJDBC3del {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC", "root", "admin");
            //注意：使用的是java.sql.Statement
            //不要不小心使用到: com.mysql.jdbc.Statement;
            s = c.createStatement();
            System.out.println("获取Statment对象: " + s);

            //准备sql语句
            //注意:字符串要用单引号
            //String sql = "insert into hero value(null, "+"'冰女'"+", "+313.0f+", "+50+")";
            for(int i=20356; i<43200; i++){
                String sql = "delete from hero where id = " + i;
                s.execute(sql);
                System.out.println("执行删除语句成功");
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
        //数据库的连接是有限资源,相关操作结束后,养成关闭数据库的好习惯
        //先关闭Statment
            if(s != null){
                try{
                    s.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            //后关闭Connection
            if(c != null){
                try{
                    c.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}