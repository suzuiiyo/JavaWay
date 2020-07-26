package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAvailableIP {
    public static void main(String[] args) throws IOException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String ipRange = ip.substring(0, ip.lastIndexOf('.'));
        System.out.println("����ip��ַΪ: " + ip);
        System.out.println("������: " + ipRange);

        List<String> ips = Collections.synchronizedList(new ArrayList<>());
        //java�Դ����̳߳�
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>());
        //ԭ�Ӳ���
        AtomicInteger number = new AtomicInteger();
        for(int i=0; i<255; i++){
            String testIP = ipRange + "." + (i + 1);
            threadPool.execute(new Runnable() {
                @Override
                public void run(){
                    boolean reachable = isReachable(testIP);
                    if(reachable)
                        //System.out.println("�ҵ������ӵ�ip��ַ: " + testIP);
                        ips.add(testIP);
                    synchronized(number){
                        System.out.println("�Ѿ����: " + number.incrementAndGet() + "��ip����");
                    }
                }
            });
        }
        //�ȴ������߳̽�����ʱ��,�͹ر��̳߳�
        threadPool.shutdown();
        //�ȴ��̳߳عر�,�������ȴ�1��Сʱ
        if(threadPool.awaitTermination(1, TimeUnit.HOURS)){
            System.out.println("����ip��ַ��������");
            for(String theip : ips){
                System.out.println(theip);
            }
            System.out.println("�ܹ���: " + ips.size() + " ����ַ");
        }
    }

    private static boolean isReachable(String ipp){
        try{
            boolean reachable = false;
            Process p = Runtime.getRuntime().exec("ping -n  1 " + ipp);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine()) != null){
                if(line.length() != 0)
                    sb.append(line + "\r\n");
            }
            //����TTL���ֵ�ʱ��,�ͱ�ʾ��ͨ��
            reachable = sb.toString().contains("TTL");
            br.close();
            return reachable;
        }
        catch(IOException e){
            //TODO
            e.printStackTrace();
            return false;
        }

        /*Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            if(line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("����ָ��ص���Ϣ��: ");
        System.out.println(sb.toString());*/
    }
}