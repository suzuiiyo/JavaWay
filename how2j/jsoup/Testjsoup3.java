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
        //通过id获取
        Element e = doc.getElementById("productName");
        System.out.println(e);

        //通过标签获取
        Elements es;
        es = doc.getElementsByTag("a");
        show(es);

        //通过类名称获取
        es = doc.getElementsByClass("RightBox");
        show(es);

        //通过属性获取
        es = doc.getElementsByAttribute("name");
        show(es);
    } 

    private static void show(Elements es){
        for(Element e : es)
            System.out.println(e);
    }
}
