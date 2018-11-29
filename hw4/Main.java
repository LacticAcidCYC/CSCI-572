package hw4.hw4;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import javax.swing.text.Document;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> fileUrlMap = new HashMap<>();
        HashMap<String, String> urlFileMap = new HashMap<>();
        String dirPath = "/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/4/mercurynews/mercurynews_html_files";
        File dir = new File(dirPath);
        Set<String> edges = new HashSet<>();
        File result = new File("/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/4/result.txt");
        File mapFile = new File("/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/4/mercurynews/URLtoHTML_mercury.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(mapFile));
            String line = "";
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] content = line.split(",");
                fileUrlMap.put(content[0],content[1]);
                urlFileMap.put(content[1],content[0]);

                //System.out.println(content[0] + " " + content[1]);

            }
            FileWriter fw = new FileWriter(result);
            BufferedWriter bw = new BufferedWriter(fw);
            for (File file : dir.listFiles()) {
                //System.out.print(fileUrlMap.get("5f5c463d-712e-4f99-9ac0-651321ea69c7.html"));
                if (fileUrlMap.get(file.getName())==null) {
                    continue;
                }
                Document doc = Jsoup.parse(file, "utf-8", fileUrlMap.get(file.getName()));
                Elements links = doc.select("a[href]");
                Elements pngs = doc.select("[src]");
                for (Element link : links) {
                    String url = link.attr("abs:href").trim();
                    if (urlFileMap.containsKey(url)) {
                        edges.add(file.getName()+" "+urlFileMap.get(url)+"\n");
                    }
                }
            }
            for (String s : edges) {
                bw.write(s);
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
}