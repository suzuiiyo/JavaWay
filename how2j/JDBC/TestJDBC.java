package jdbc;

public class TestJDBC{
    public static void main(String[] args) {
        try{
            //������com.mysql��jdbc.Driver
            //����mysql-connector-java-***.jar
            //������ǵ�һ������ĵ���,�ͻ��׳�ClassNotFoundException
            Class.forName("com.mysql.cj.jdbc.Driver");    //��������com.mysql.jdbc.Driver(����),��������com.mysql.cj.jdbc.Driver
            System.out.println("���ݿ��������سɹ�!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}