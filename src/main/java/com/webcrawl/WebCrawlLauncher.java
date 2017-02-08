/**
 * 
 */
package com.webcrawl;

import java.io.IOException;

import com.webcrawl.exception.WebCrawlerException;
import com.webcrawl.service.WebCrawlerServiceImpl;

/**
 * @author jvvss
 *
 */
public class WebCrawlLauncher {

	/**
	 * The launcher of the web crawling - main class
	 * @param args
	 * @throws WebCrawlerException 
	 */
	public static void main(String[] args) throws WebCrawlerException {
          try {
			WebCrawlerServiceImpl.class.newInstance().crawler(args);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			throw new WebCrawlerException(e.getMessage(), e);
		}
		
	}

}
