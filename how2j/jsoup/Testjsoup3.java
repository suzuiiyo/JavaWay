package jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Testjsoup3 {
    public static void main(String[] args) throws IOException {
        File f = new File("d:/Studio/JavaWay/how2j/jsoup/b.html");
        if(!f.exists())
            return;
        Document doc = Jsoup.parse(f, "utf-8");
        //ͨ��id��ȡ
        Element e = doc.getElementById("productName");
        System.out.println(e);

        //ͨ����ǩ��ȡ
        Elements es;
        es = doc.getElementsByTag("a");
        show(es);

        //ͨ�������ƻ�ȡ
        es = doc.getElementsByClass("RightBox");
        show(es);

        //ͨ�����Ի�ȡ
        es = doc.getElementsByAttribute("name");
        show(es);
    } 

    private static void show(Elements es){
        for(Element e : es)
            System.out.println(e);
    }
}
