package jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestSelect {
    static Document doc;

    public static void main(String[] args) throws IOException {
        File f = new File("d:/Studio/JavaWay/how2j/jsoup/b.html");
        if(!f.exists())
            return;

        doc = Jsoup.parse(f, "utf-8");

        //��jquery������ѡ�����﷨
        show("ѡ�����еĳ���", "a");
        show("����id����ѡ��", "#logocover");
        show("����class����ѡ��", ".clearfloat");
        show("�������Խ���ѡ��", "[href]");
        show("��������tar��ͷ", "[^tar]");
        show("��������ֵѡ��", "[type='application/javascript']");
        //show("����ֵ��ʲô��ͷ", "[href^='http://www.oracle.com'");
        show("����ֵ��ʲô��β", "[href$='index.html']");
        show("����ֵ����ʲô", "[href*='download']");
    }

    private static void show(String text, String selector){
        show(text, selector, 3);
    }

    private static void show(String text, String selector, int limit){
        Elements es = doc.select(selector);
        if(es.size()>1)
            System.out.println(String.format("%s -ʹ�õ�ѡ������: \"%s\" \t (�����ʾ%d��)", text, selector, limit));
        else
            System.out.println(String.format("%s - ʹ�õ�ѡ�����ǣ�\"%s\"", text, selector));
        
        int i=0;
        for(Element e : es){
            if(i++<limit)
                System.out.println(e);
        }
        System.out.println();
    }
}
