package com.gamechange.issuefetcher.viewInterface;

import com.gamechange.issuefetcher.model.Comment;
import com.gamechange.issuefetcher.model.Issue;

import java.util.ArrayList;

public interface IIssueList extends IBaseInterface{
    void onFetchIssues(ArrayList<Issue> issues);
    void onFetchComments(ArrayList<Comment> comments);
}
