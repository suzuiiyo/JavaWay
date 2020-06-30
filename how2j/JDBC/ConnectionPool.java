package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    List<Connection> cs = new ArrayList<Connection>();

    int size;
    public ConnectionPool(int size){
        this.size = size;
        init();
    }

    public void init(){
        String drive = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/how2java";
        String factor = "?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String upassword = "admin";
        //����ǡǡ����ʹ��try-with-resource�ķ�ʽ,��Ϊ��Щ���Ӷ���Ҫ�ǻ�ģ���Ҫ���Զ��ر�
        try{
            Class.forName(drive);
            System.out.println("�������سɹ�");
            for(int i=0; i<size; i++){
                Connection c = DriverManager.getConnection(url+factor, user, upassword);
                cs.add(c);
            }
        }catch(ClassNotFoundException | SQLException e){
            //TODO.print something
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection(){
        while(cs.isEmpty()){
            try{
                this.wait();
            }catch(InterruptedException e){
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }

    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }
}