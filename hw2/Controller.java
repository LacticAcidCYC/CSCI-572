package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
	
	public static final String FETCH_TARGET = "https://www.wsj.com/";
	
	/*Basic configuration of the crawler*/
    private static final int numberOfCrawlers = 7;
    private static final int maxPagesToFetch = 20000;
    private static final int maxDepthOfCrawling = 16;
    private static final int politenessDelay = 1000;

	public static void main(String[] args) throws Exception {
		String crawlStorageFolder = "/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/2/data/crawl";
        String fetchFile = "fetch_wsj.csv";
        String visitFile = "visit_wsj.csv";
        String urlsFile = "urls_wsj.csv";
        String countFile = "count.txt";
        
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(maxDepthOfCrawling);
        config.setMaxPagesToFetch(maxPagesToFetch);
        //config.setPolitenessDelay(politenessDelay);
        config.setIncludeBinaryContentInCrawling(true);
        config.setIncludeHttpsPages(true);
        config.setFollowRedirects(true);
        /*
         * Instantiate the controller for this crawl.
         */
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
		
		/*Create storage file*/
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(crawlStorageFolder+"/"+fetchFile));
            bw.write("URL, Status Code\n");
            bw.close();

            bw = new BufferedWriter(new FileWriter(crawlStorageFolder+"/"+visitFile));
            bw.write("URLs Downloaded, Size, # of outlinks found, Content-type\n");
            bw.close();

            bw = new BufferedWriter(new FileWriter(crawlStorageFolder+"/"+urlsFile));
            bw.write("Encountered URL, Indicator\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
		
		/*
		* For each crawl, you need to add some seed urls. These are the first
		* URLs that are fetched and then the crawler starts following links
		* which are found in these pages
		*/
		controller.addSeed(FETCH_TARGET);
		
		/*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(crawlStorageFolder+"/"+countFile));
            writer.write("< 1KB: "+MyCrawler.sizeCount[0]+"\n");
            writer.write("1KB ~ <10KB: "+MyCrawler.sizeCount[1]+"\n");
            writer.write("10KB ~ <100KB: "+MyCrawler.sizeCount[2]+"\n");
            writer.write("100KB ~ <1MB: "+MyCrawler.sizeCount[3]+"\n");
            writer.write(">= 1MB: "+MyCrawler.sizeCount[4]+"\n");
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Fethced attemps: "+MyCrawler.url_cnt);
	}

}
