package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {
	
	private String crawlStorageFolder = "/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/2/data/crawl";
    private String fetchFile = "fetch_wsj.csv";
    private String visitFile = "visit_wsj.csv";
    private String urlsFile = "urls_wsj.csv";
    
    public static int url_cnt = 0;
    public static int[] sizeCount = new int[5];
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|feed|rss|svg|js|mp3|zip|gz|vcf|xml|php|json|ico))$");
	
	/** This function is called once the header of a page is fetched. It can be
    * overridden by sub classes to perform custom logic for different status
    * codes. For example, 404 pages can be logged, etc.
    *
    * @param webUrl WebUrl containing the statusCode
    * @param statusCode Html Status Code number
    * @param statusDescription Html Status Code description
    */
	@Override
	protected void handlePageStatusCode(WebURL webUrl, int statusCode, String statusDescription) {
		url_cnt++;
		synchronized (this) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(crawlStorageFolder+"/"+fetchFile, true));
				writer.write(webUrl.getURL().replace(",", "_")+","+statusCode+"\n");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	* This method receives two parameters. The first parameter is the page
	* in which we have discovered this new url and the second parameter is
	* the new url. You should implement this function to specify whether
	* the given url should be crawled or not (based on your crawling logic).
	* In this example, we are instructing the crawler to ignore urls that
	* have css, js, git, ... extensions and to only accept urls that start
	* with "http://www.viterbi.usc.edu/". In this case, we didn't need the
	* referringPage parameter to make the decision.
	*/
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		try{
            synchronized(this){
                BufferedWriter writer = new BufferedWriter(new FileWriter(crawlStorageFolder+"/"+urlsFile, true));
                if(href.startsWith("https://www.wsj.com/") || href.startsWith("https://wsj.com/")
                		|| href.startsWith("http://www.wsj.com/") || href.startsWith("http://wsj.com/"))
                	writer.write(url.getURL().replace(",", "_") + ", OK\n");
                else
                	writer.write(url.getURL().replace(",", "_")+ ", N_OK\n");
                writer.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
		if (referringPage != null && referringPage.getContentType() != null
				&& !referringPage.getContentType().contains("text/html")
				&& !referringPage.getContentType().contains("image/gif")
				&& !referringPage.getContentType().contains("image/jpeg")
				&& !referringPage.getContentType().contains("image/png")
				&& !referringPage.getContentType().contains("application/pdf")) {
			return false;
		}
		return !FILTERS.matcher(href).matches()
			&& href.startsWith("https://www.wsj.com/");
	}

	/**
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     */
	@Override
	public void visit(Page page) {
	   String url = page.getWebURL().getURL();
	   System.out.println("URL: " + url);
	   int size = page.getContentData().length;
       int sizeKB = size/1024;
       int numOfOutlink = page.getParseData().getOutgoingUrls().size();
       String contentType = page.getContentType();
       contentType = contentType.toLowerCase().indexOf(";") > -1
                     ? contentType.substring(0, contentType.indexOf(";")) : contentType;
	   
//	   if (page.getParseData() instanceof HtmlParseData) {
//	       HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
//	       String text = htmlParseData.getText();
//	       String html = htmlParseData.getHtml();
//	       Set<WebURL> links = htmlParseData.getOutgoingUrls();
//	       System.out.println("Text length: " + text.length());
//	       System.out.println("Html length: " + html.length());
//	       System.out.println("Number of outgoing links: " + links.size());
//	   }
	   try{
           synchronized (this){
               if(sizeKB<1)
                   sizeCount[0]++;
               else if(1 <= sizeKB && sizeKB < 10)
                   sizeCount[1]++;
               else if(10 <= sizeKB && sizeKB < 100)
                   sizeCount[2]++;
               else if(100 <= sizeKB && sizeKB <1024)
                   sizeCount[3]++;
               else
                   sizeCount[4]++;
               BufferedWriter writer = new BufferedWriter(new FileWriter(crawlStorageFolder + "/" + visitFile, true));
               writer.write(url.replace(",", "_") + "," + size + "," + numOfOutlink + "," + contentType +"\n");
               writer.close();
               System.out.println(crawlStorageFolder + "/" + visitFile);
           }
       } catch(IOException e){
           e.printStackTrace();
       }
	}
}
