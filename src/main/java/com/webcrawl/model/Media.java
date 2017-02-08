package com.webcrawl.model;

import java.io.Serializable;

public class Media implements Serializable{

	private static final long serialVersionUID = 7751606915150375776L;
	
	private String mediaURL;
	
	public Media(String mediaURL){
		this.mediaURL = mediaURL;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public String toString(){
		return mediaURL.trim().toString();
	}

}
