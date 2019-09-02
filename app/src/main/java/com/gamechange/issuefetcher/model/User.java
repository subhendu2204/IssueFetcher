package com.gamechange.issuefetcher.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Parcelable {

	@JsonProperty("gists_url")
	private String gistsUrl;

	@JsonProperty("repos_url")
	private String reposUrl;

	@JsonProperty("following_url")
	private String followingUrl;

	@JsonProperty("starred_url")
	private String starredUrl;

	@JsonProperty("login")
	private String login;

	@JsonProperty("followers_url")
	private String followersUrl;

	@JsonProperty("type")
	private String type;

	@JsonProperty("url")
	private String url;

	@JsonProperty("subscriptions_url")
	private String subscriptionsUrl;

	@JsonProperty("received_events_url")
	private String receivedEventsUrl;

	@JsonProperty("avatar_url")
	private String avatarUrl;

	@JsonProperty("events_url")
	private String eventsUrl;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("site_admin")
	private boolean siteAdmin;

	@JsonProperty("id")
	private int id;

	@JsonProperty("gravatar_id")
	private String gravatarId;

	@JsonProperty("node_id")
	private String nodeId;

	@JsonProperty("organizations_url")
	private String organizationsUrl;

	public User(){}

	protected User(Parcel in) {
		gistsUrl = in.readString();
		reposUrl = in.readString();
		followingUrl = in.readString();
		starredUrl = in.readString();
		login = in.readString();
		followersUrl = in.readString();
		type = in.readString();
		url = in.readString();
		subscriptionsUrl = in.readString();
		receivedEventsUrl = in.readString();
		avatarUrl = in.readString();
		eventsUrl = in.readString();
		htmlUrl = in.readString();
		siteAdmin = in.readByte() != 0;
		id = in.readInt();
		gravatarId = in.readString();
		nodeId = in.readString();
		organizationsUrl = in.readString();
	}

	public static final Creator<User> CREATOR = new Creator<User>() {
		@Override
		public User createFromParcel(Parcel in) {
			return new User(in);
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};

	public void setGistsUrl(String gistsUrl){
		this.gistsUrl = gistsUrl;
	}

	public String getGistsUrl(){
		return gistsUrl;
	}

	public void setReposUrl(String reposUrl){
		this.reposUrl = reposUrl;
	}

	public String getReposUrl(){
		return reposUrl;
	}

	public void setFollowingUrl(String followingUrl){
		this.followingUrl = followingUrl;
	}

	public String getFollowingUrl(){
		return followingUrl;
	}

	public void setStarredUrl(String starredUrl){
		this.starredUrl = starredUrl;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}

	public void setFollowersUrl(String followersUrl){
		this.followersUrl = followersUrl;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setSubscriptionsUrl(String subscriptionsUrl){
		this.subscriptionsUrl = subscriptionsUrl;
	}

	public String getSubscriptionsUrl(){
		return subscriptionsUrl;
	}

	public void setReceivedEventsUrl(String receivedEventsUrl){
		this.receivedEventsUrl = receivedEventsUrl;
	}

	public String getReceivedEventsUrl(){
		return receivedEventsUrl;
	}

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setEventsUrl(String eventsUrl){
		this.eventsUrl = eventsUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setSiteAdmin(boolean siteAdmin){
		this.siteAdmin = siteAdmin;
	}

	public boolean isSiteAdmin(){
		return siteAdmin;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setGravatarId(String gravatarId){
		this.gravatarId = gravatarId;
	}

	public String getGravatarId(){
		return gravatarId;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}

	public void setOrganizationsUrl(String organizationsUrl){
		this.organizationsUrl = organizationsUrl;
	}

	public String getOrganizationsUrl(){
		return organizationsUrl;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(gistsUrl);
		parcel.writeString(reposUrl);
		parcel.writeString(followingUrl);
		parcel.writeString(starredUrl);
		parcel.writeString(login);
		parcel.writeString(followersUrl);
		parcel.writeString(type);
		parcel.writeString(url);
		parcel.writeString(subscriptionsUrl);
		parcel.writeString(receivedEventsUrl);
		parcel.writeString(avatarUrl);
		parcel.writeString(eventsUrl);
		parcel.writeString(htmlUrl);
		parcel.writeByte((byte) (siteAdmin ? 1 : 0));
		parcel.writeInt(id);
		parcel.writeString(gravatarId);
		parcel.writeString(nodeId);
		parcel.writeString(organizationsUrl);
	}
}