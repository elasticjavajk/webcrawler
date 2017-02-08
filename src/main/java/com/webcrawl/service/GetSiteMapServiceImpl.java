package com.webcrawl.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.log4testng.Logger;

import com.webcrawl.exception.WebCrawlerException;
import com.webcrawl.model.HTMLDoc;
import com.webcrawl.utils.CrawlConstants;
import com.webcrawl.utils.LinkStatus;

public class GetSiteMapServiceImpl implements GetSiteMapService{
	
	Logger LOG = Logger.getLogger(GetSiteMapServiceImpl.class);

	private Set<String> scrapedLinks = new HashSet<String>();
	private Set<String> scannedImgs = new HashSet<String>();

	/**
	 * To get the sitemap for the provided domain.
	 * @param url
	 * @exception WebCrawlerException
	 * 
	 */
	public HTMLDoc getSitemap(String url) throws WebCrawlerException {
		HTMLDoc siteMap;		
		Document doc;

		try {
			doc = getDocument(url);

			siteMap = new HTMLDoc(url, doc.title(), doc.baseUri(), LinkStatus.Visited);

			getHTMLDocLinks(siteMap, doc.select("a[href]") );
			getHTMLDocMedia(doc.select("[src]"), siteMap);

		} catch (IOException ex) {
			LOG.error("WebCrawling Failed - ",ex);
			throw new WebCrawlerException("Crawling failed in getting sitemap",ex);
		}

		return siteMap;
	}

	/**
	 * To get the Links available under the crawled page and the local links of that particular screen
	 * @param hostURL
	 * @param siteMap
	 * @param links
	 * @throws IOException
	 */
	private void getHTMLDocLinks(HTMLDoc siteMap, Elements links ) throws IOException {
		for (Element link : links) {
			String pageURL = link.attr("abs:href");
			if (pageURL.startsWith(CrawlConstants.MAIN_URL_TO_CRAWL) && !scrapedLinks.contains(pageURL)) {
				scrapedLinks.add(pageURL);
				try {
					siteMap.getChildLinksList().add(getSitemap(pageURL));
				} catch (WebCrawlerException ex) {					
					LOG.error("Web Crawling failed - ",ex);
				}
				print(padLeft("[-]", link.siblingIndex()+1)+" <%s> - [%s]", link.attr("abs:href"), LinkStatus.Visited, link.siblingIndex());
			} 
		}
	}

	/**
	 * To get the media sources used in the pages/site
	 * @param media
	 * @param siteMap
	 */
	private void getHTMLDocMedia(Elements media, HTMLDoc siteMap) {
		for (Element src : media) {
			if (src.tagName().equals("img") && src.baseUri().startsWith(CrawlConstants.MAIN_URL_TO_CRAWL) && !scannedImgs.contains(src.attr("abs:src"))){
				print("[-] %s - <%s>",
						src.tagName(), src.attr("abs:src"));
				scannedImgs.add(src.attr("abs:src"));
			} 
		}
	}

	private static void print(String msg, Object... args)  {
		System.out.println(String.format(msg, args));
	}
	
	/**
	 * To get the HTML document of the provided url
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private Document getDocument(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
	
	/**
	 * To pad the tree based on the level 
	 * @param s - string
	 * @param n - level
	 * @return
	 */
	private static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);  
	}

}
