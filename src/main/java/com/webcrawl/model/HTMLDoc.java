package com.webcrawl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.webcrawl.utils.LinkStatus;

public class HTMLDoc implements Serializable{
	
	private static final long serialVersionUID = -2733200021153811749L;

	private String baseURI;
	
	private String linkStatus;
	
	private String url;
	
	private String text;
	
	private List<HTMLDoc> childLinksList = new ArrayList<HTMLDoc>();
	private List<Media> mediaList = new ArrayList<Media>();
	
	public HTMLDoc(String url, String text, String baseURI, LinkStatus linkStatus){
		this.url = url;
		this.text = text;
		this.baseURI = baseURI;
		this.linkStatus = linkStatus.toString();
		
	}

	public String getBaseURI() {
		return baseURI;
	}

	public String getUrl() {
		return url;
	}

	public String getText() {
		return text;
	}

	public List<HTMLDoc> getChildLinksList() {
		return childLinksList;
	}

	public void setLinks(List<HTMLDoc> childLinksList) {
		this.childLinksList = childLinksList;
	}
	
	public List<Media> getMediaList() {
		return mediaList;
	}

	public void setMedia(List<Media> mediaList) {
		this.mediaList = mediaList;
	}

	public String toString(){
		return "[-] "+url+" ["+linkStatus+"]";
	}

}
