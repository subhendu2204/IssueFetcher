package com.gamechange.issuefetcher.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
		"url",
		"html_url",
		"issue_url",
		"id",
		"node_id",
		"user",
		"created_at",
		"updated_at",
		"author_association",
		"body"
})

public class Comment implements Parcelable {

	@JsonProperty("author_association")
	private String authorAssociation;

	@JsonProperty("issue_url")
	private String issueUrl;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("id")
	private int id;

	@JsonProperty("body")
	private String body;

	@JsonProperty("user")
	private User user;

	@JsonProperty("url")
	private String url;

	@JsonProperty("node_id")
	private String nodeId;

	public Comment(){}

	protected Comment(Parcel in) {
		authorAssociation = in.readString();
		issueUrl = in.readString();
		updatedAt = in.readString();
		htmlUrl = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		body = in.readString();
		url = in.readString();
		nodeId = in.readString();
		user = (User) in.readValue(User.class.getClassLoader());
	}

	public static final Creator<Comment> CREATOR = new Creator<Comment>() {
		@Override
		public Comment createFromParcel(Parcel in) {
			return new Comment(in);
		}

		@Override
		public Comment[] newArray(int size) {
			return new Comment[size];
		}
	};

	public void setAuthorAssociation(String authorAssociation){
		this.authorAssociation = authorAssociation;
	}

	public String getAuthorAssociation(){
		return authorAssociation;
	}

	public void setIssueUrl(String issueUrl){
		this.issueUrl = issueUrl;
	}

	public String getIssueUrl(){
		return issueUrl;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(authorAssociation);
		parcel.writeString(issueUrl);
		parcel.writeString(updatedAt);
		parcel.writeString(htmlUrl);
		parcel.writeString(createdAt);
		parcel.writeInt(id);
		parcel.writeString(body);
		parcel.writeString(url);
		parcel.writeString(nodeId);
		parcel.writeValue(user);
	}
}