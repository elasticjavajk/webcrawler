package com.webcrawl.service;

import java.io.IOException;

import com.webcrawl.exception.WebCrawlerException;
import com.webcrawl.model.HTMLDoc;

public interface GetSiteMapService {
	
	public HTMLDoc getSitemap(String url) throws IOException, WebCrawlerException; 

}
