package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPing {
    /*public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            if(line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("����ָ��ص���Ϣ��: ");
        System.out.println(sb.toString());
    }*/

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            if(line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("����ָ��ص���Ϣ��: ");
        System.out.println(sb.toString());
    }
}