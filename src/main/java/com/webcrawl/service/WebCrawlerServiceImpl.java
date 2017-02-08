package com.webcrawl.service;

import java.io.IOException;

import org.testng.log4testng.Logger;

import com.webcrawl.exception.WebCrawlerException;
import com.webcrawl.model.HTMLDoc;
import com.webcrawl.utils.CrawlConstants;

public class WebCrawlerServiceImpl {
	Logger LOG = Logger.getLogger(WebCrawlerServiceImpl.class);

	/**
	 * To crawl the website, if URL provided otherwise will crawl the default URL configured in the system
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public void crawler(String... args) throws InstantiationException, IllegalAccessException, IOException {
		String urlToCrawl = (args.length == 0) ? CrawlConstants.MAIN_URL_TO_CRAWL : args[0].trim();
		try {
			HTMLDoc siteMap = GetSiteMapServiceImpl.class.newInstance().getSitemap(urlToCrawl);
		} catch (WebCrawlerException ex) {
			LOG.error("WebCrawling failed -",ex);
		}
	}

}
