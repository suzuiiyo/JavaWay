package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Testjsoup {
    public static void main(String[] args) {
        String html = "<html><body><p>Hello HTML</p></body></html>";
        Document doc = Jsoup.parse(html);

        Elements as = doc.getElementsByTag("p");
        for(Element e : as)
            System.out.println(e.text());
    }
}
