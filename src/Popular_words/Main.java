package Popular_words;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Main {
    public static void main(String[] args){

        Connection[] connect = new Connection[3];
        String[] cssQuery = new String[3];

        connect[0] = Jsoup.connect("https://www.onet.pl/");
        cssQuery[0] = "span.title";
        connect[1] = Jsoup.connect("https://www.spidersweb.pl/");
        cssQuery[1] = "span.postlink-inner";
        connect[2] = Jsoup.connect("https://gazetawroclawska.pl/");
        cssQuery[2] = "h2";

        try
        {
            for (int i=0; i<connect.length; i++)
            {
                Document document = connect[i].get();

                Elements links = document.select(cssQuery[i]);

                for (Element elem : links)
                {
                    System.out.println(elem.text());
                }
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
