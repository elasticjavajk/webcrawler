package com.webcrawl.exception;

public class WebCrawlerException extends Exception{
	
private static final long serialVersionUID = 468433161499988478L;
	
	public WebCrawlerException(String message){
		super(message);
	}
	
	public WebCrawlerException(Throwable cause){
		super(cause);
	}
	
	public WebCrawlerException(String message, Throwable cause){
		super(message, cause);
	}


}
