package jdbc;

public class TestJDBC{
    public static void main(String[] args) {
        try{
            //驱动类com.mysql。jdbc.Driver
            //就在mysql-connector-java-***.jar
            //如果忘记第一个步骤的导包,就会抛出ClassNotFoundException
            Class.forName("com.mysql.cj.jdbc.Driver");    //老驱动是com.mysql.jdbc.Driver(废弃),新驱动是com.mysql.cj.jdbc.Driver
            System.out.println("数据库驱动加载成功!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}