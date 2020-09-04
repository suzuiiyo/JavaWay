package jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestModify {
    static Document doc;
    public static void main(String[] args) throws IOException {
        File f = new File("d:/Studio/JavaWay/how2j/jsoup/a.html");
        if(!f.exists())
            return;
        
        doc = Jsoup.parse(f, "utf-8");
        System.out.println(doc);
        Element e = doc.select("p").first();
        //–ﬁ∏ƒ Ù–‘
        e.attr("class", "class1");

        e.appendText(" Hello Jsoup");
        System.out.println();
        System.out.println(doc);
    }
}
