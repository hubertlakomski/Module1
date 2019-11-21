package Popular_words;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        //Arrays of websites links and their header designation
        Connection[] websites = new Connection[3];
        String[] cssQuery = new String[3];

        //path to creating files
        Path path1 = Paths.get("popular_words.txt");
        Path path2 = Paths.get("filtered_popular_words.txt");

        //links to websites and html header designation
        websites[0] = Jsoup.connect("https://www.onet.pl/");
        cssQuery[0] = "span.title";
        websites[1] = Jsoup.connect("https://www.spidersweb.pl/");
        cssQuery[1] = "span.postlink-inner";
        websites[2] = Jsoup.connect("https://gazetawroclawska.pl/");
        cssQuery[2] = "h2";

        //word list excluded from the output file
        String[] excluded = {"Obrady", "statutowa"};

        //creating file with words longer then 3 characters
        wordsToFile(websites, cssQuery, path1);

        //creating a new file from the file created in the previous method without excluded words
        writeWithoutExclusion(path1, path2, excluded);

    }

    public static void writeWithoutExclusion(Path fileFromWrite, Path fileToWrite, String[] excluded) throws IOException {

        Files.deleteIfExists(fileToWrite);
        Files.createFile(fileToWrite);

        List<String> words = Files.readAllLines(fileFromWrite);

        for(String word: words){
            if(!checkExclusion(word, excluded)){
                Files.write(fileToWrite, Collections.singletonList(word), StandardOpenOption.APPEND);
            }
        }

    }

    private static boolean checkExclusion(String word, String[] excluded){

        for(String excludedWord: excluded){
            if(word.equals(excludedWord)){
                return true;
            }
        }

        return false;
    }

    public static void wordsToFile(Connection[] websites, String[] cssQuery, Path path) throws IOException {

        Files.deleteIfExists(path);
        Files.createFile(path);

        for (int i=0; i<websites.length; i++) {

            //loading headers from the website
            Document document = websites[i].get();

            Elements links = document.select(cssQuery[i]);

            for (Element elem : links) {

                //dividing header into words
                String tmp = elem.text();
                String[] words = tmp.split(" ");

                for(String word: words) {

                    //writing only words longer then 3 characters to the file
                    if(word.length()>3) {
                        Files.write(path, Collections.singletonList(word), StandardOpenOption.APPEND);
                    }
                }
            }
        }
    }

    }
