package com.gamechange.issuefetcher.model;

import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamechange.issuefetcher.utils.Utils;

public class Issue {

	@JsonProperty("pull_request")
	private PullRequest pullRequest;

	@JsonProperty("comments")
	private int comments;

	@JsonProperty("closed_at")
	private Object closedAt;

	@JsonProperty("assignees")
	private List<AssigneesItem> assignees;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("url")
	private String url;

	@JsonProperty("labels")
	private List<LabelsItem> labels;

	@JsonProperty("labels_url")
	private String labelsUrl;

	@JsonProperty("author_association")
	private String authorAssociation;

	@JsonProperty("number")
	private int number;

	@JsonProperty("milestone")
	private Object milestone;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("events_url")
	private String eventsUrl;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("comments_url")
	private String commentsUrl;

	@JsonProperty("repository_url")
	private String repositoryUrl;

	@JsonProperty("id")
	private int id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("assignee")
	private Assignee assignee;

	@JsonProperty("locked")
	private boolean locked;

	@JsonProperty("user")
	private User user;

	@JsonProperty("node_id")
	private String nodeId;

	public void setPullRequest(PullRequest pullRequest){
		this.pullRequest = pullRequest;
	}

	public PullRequest getPullRequest(){
		return pullRequest;
	}

	public void setComments(int comments){
		this.comments = comments;
	}

	public int getComments(){
		return comments;
	}

	public void setClosedAt(Object closedAt){
		this.closedAt = closedAt;
	}

	public Object getClosedAt(){
		return closedAt;
	}

	public void setAssignees(List<AssigneesItem> assignees){
		this.assignees = assignees;
	}

	public List<AssigneesItem> getAssignees(){
		return assignees;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setLabels(List<LabelsItem> labels){
		this.labels = labels;
	}

	public List<LabelsItem> getLabels(){
		return labels;
	}

	public void setLabelsUrl(String labelsUrl){
		this.labelsUrl = labelsUrl;
	}

	public String getLabelsUrl(){
		return labelsUrl;
	}

	public void setAuthorAssociation(String authorAssociation){
		this.authorAssociation = authorAssociation;
	}

	public String getAuthorAssociation(){
		return authorAssociation;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setMilestone(Object milestone){
		this.milestone = milestone;
	}

	public Object getMilestone(){
		return milestone;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public void setCommentsUrl(String commentsUrl){
		this.commentsUrl = commentsUrl;
	}

	public String getCommentsUrl(){
		return commentsUrl;
	}

	public void setRepositoryUrl(String repositoryUrl){
		this.repositoryUrl = repositoryUrl;
	}

	public String getRepositoryUrl(){
		return repositoryUrl;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setAssignee(Assignee assignee){
		this.assignee = assignee;
	}

	public Assignee getAssignee(){
		return assignee;
	}

	public void setLocked(boolean locked){
		this.locked = locked;
	}

	public boolean isLocked(){
		return locked;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}

	public static final Comparator<Issue> COMPARE_BY_UPDATED_DATE = new Comparator<Issue>() {
		@Override
		public int compare(Issue issue, Issue t1) {
			return Utils.getParsedDate(t1.getUpdatedAt(), Utils.DATE_FORMAT).compareTo(Utils.getParsedDate(issue.getUpdatedAt(), Utils.DATE_FORMAT));
		}
	};

	@Override
	public String toString() {
		return "Issue{" +
				"pullRequest=" + pullRequest +
				", comments=" + comments +
				", closedAt=" + closedAt +
				", assignees=" + assignees +
				", createdAt='" + createdAt + '\'' +
				", title='" + title + '\'' +
				", body='" + body + '\'' +
				", url='" + url + '\'' +
				", labels=" + labels +
				", labelsUrl='" + labelsUrl + '\'' +
				", authorAssociation='" + authorAssociation + '\'' +
				", number=" + number +
				", milestone=" + milestone +
				", updatedAt='" + updatedAt + '\'' +
				", eventsUrl='" + eventsUrl + '\'' +
				", htmlUrl='" + htmlUrl + '\'' +
				", commentsUrl='" + commentsUrl + '\'' +
				", repositoryUrl='" + repositoryUrl + '\'' +
				", id=" + id +
				", state='" + state + '\'' +
				", assignee=" + assignee +
				", locked=" + locked +
				", user=" + user +
				", nodeId='" + nodeId + '\'' +
				'}';
	}
}