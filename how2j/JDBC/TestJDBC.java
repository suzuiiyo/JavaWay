package JDBC;

public class TestJDBC{
    public static void main(String[] args) {
        try{
            //������com.mysql��jdbc.Driver
            //����mysql-connector-java-***.jar
            //������ǵ�һ������ĵ���,�ͻ��׳�ClassNotFoundException
            Class.forName("come.mysql-jdbc.Driver");
            System.out.println("���ݿ��������سɹ�!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}