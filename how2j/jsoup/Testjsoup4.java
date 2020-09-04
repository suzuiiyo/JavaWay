package jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Testjsoup4 {
    public static void main(String[] args) throws IOException {
        File f = new File("d:/Studio/JavaWay/how2j/jsoup/c.html");
        if(!f.exists())
            return;

        Document doc = Jsoup.parse(f, "utf-8");
        Element e = doc.getElementById("dl");

        //��ȡ����
        System.out.println(e.attr("id"));
        //��ȡ��������
        System.out.println(e.attributes());
        //��ȡid
        System.out.println(e.id());

        //��ȡ������
        System.out.println(e.className());
        //��ȡ����������
        System.out.print(e.classNames());
        //��ȡ�ı�
        System.out.println(e.text());
        //��ȡhtml
        System.out.println(e.html());
        //��ȡ��html
        System.out.println(e.outerHtml());
        //��ȡ��ǩ��Ϣ
        System.out.println(e.tagName());
    }
}
