package jsoup;

import java.io.File;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Testjsoup2 {
    public static void main(String[] args) throws Exception{
        String html1 = "<html><body><p>hello HTML</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        System.out.println("�����ַ�����ʽ�õ���Document:\r\n" + doc1);

        //File f = new File("d:/Studio/JavaWay/AC/DC/hutubillDemo/��һ��.html");
        File f = new File("d:/Studio/JavaWay/how2j/jsoup/a.html");
        if(f.exists()){
            Document doc2 = Jsoup.parse(f, "utf-8");
            System.out.println("�����ļ���ʽ�õ���Document:\r\n" + doc2);
        }

        String url = "http://www.baidu.com";
        Document doc3 = Jsoup.parse(new URL(url), 5000);   //����5��ͱ���
        System.out.println("����URL��ʽ�õ���Document:\r\n" + doc3);
    }
}
