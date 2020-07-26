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
        System.out.println("本机ip地址为: " + ip);
        System.out.println("网段是: " + ipRange);

        List<String> ips = Collections.synchronizedList(new ArrayList<>());
        //java自带的线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>());
        //原子操作
        AtomicInteger number = new AtomicInteger();
        for(int i=0; i<255; i++){
            String testIP = ipRange + "." + (i + 1);
            threadPool.execute(new Runnable() {
                @Override
                public void run(){
                    boolean reachable = isReachable(testIP);
                    if(reachable)
                        //System.out.println("找到可连接的ip地址: " + testIP);
                        ips.add(testIP);
                    synchronized(number){
                        System.out.println("已经完成: " + number.incrementAndGet() + "个ip测试");
                    }
                }
            });
        }
        //等待所有线程结束的时候,就关闭线程池
        threadPool.shutdown();
        //等待线程池关闭,但是最多等待1个小时
        if(threadPool.awaitTermination(1, TimeUnit.HOURS)){
            System.out.println("如下ip地址可以连接");
            for(String theip : ips){
                System.out.println(theip);
            }
            System.out.println("总共有: " + ips.size() + " 个地址");
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
            //当有TTL出现的时候,就表示连通了
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
        System.out.println("本次指令返回的消息是: ");
        System.out.println(sb.toString());*/
    }
}