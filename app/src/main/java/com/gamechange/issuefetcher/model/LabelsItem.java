package com.gamechange.issuefetcher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LabelsItem{

	@JsonProperty("default")
	private boolean jsonMemberDefault;

	@JsonProperty("color")
	private String color;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("url")
	private String url;

	@JsonProperty("node_id")
	private String nodeId;

	public void setJsonMemberDefault(boolean jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	public boolean isJsonMemberDefault(){
		return jsonMemberDefault;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}
}