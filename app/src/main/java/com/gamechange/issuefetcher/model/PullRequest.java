package com.gamechange.issuefetcher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PullRequest{

	@JsonProperty("patch_url")
	private String patchUrl;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("diff_url")
	private String diffUrl;

	@JsonProperty("url")
	private String url;

	public void setPatchUrl(String patchUrl){
		this.patchUrl = patchUrl;
	}

	public String getPatchUrl(){
		return patchUrl;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setDiffUrl(String diffUrl){
		this.diffUrl = diffUrl;
	}

	public String getDiffUrl(){
		return diffUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}