import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class Parse {

    public static void defWriteToFile(ArrayList<String> wordList) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/lacticacid/Desktop/big.txt"));
        for(String x: wordList) {
            writer.write(x + "\n");
        }
    }

    public static void parseFiles(String html_dir_path)throws IOException, SAXException, TikaException {
        File dir = new File(html_dir_path);
        File[] html_files = dir.listFiles();
        ArrayList<String> fullText = new ArrayList();
        for(File x: html_files) {
            fullText.addAll(parseFile(x));
        }
        defWriteToFile(fullText);
    }

    public static ArrayList<String> parseFile(File myFile) throws IOException, SAXException, TikaException {
        FileInputStream inputstream = new FileInputStream(myFile);
        BodyContentHandler handler = new BodyContentHandler(-1);
        Metadata metadata = new Metadata();
        ParseContext pcontext = new ParseContext();
        
        HtmlParser htmlparser = new HtmlParser();
        htmlparser.parse(inputstream, handler, metadata, pcontext);
        return new ArrayList(Arrays.asList(handler.toString().split("\\W+")));
    }

    public static void main(String args[]) throws IOException, SAXException, TikaException {
        String html_dir_path= "/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/5/mercurynews";
        parseFiles(html_dir_path);
    }
}
