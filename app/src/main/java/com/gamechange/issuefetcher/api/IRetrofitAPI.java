package com.gamechange.issuefetcher.api;

import com.gamechange.issuefetcher.model.Comment;
import com.gamechange.issuefetcher.model.Issue;
import com.gamechange.issuefetcher.utils.Constants;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import rx.Observable;

public interface IRetrofitAPI {

    @GET(Constants.ISSUES_API)
    Observable<ArrayList<Issue>> getIssues(@HeaderMap Map<String, String> headerMap, @Path(value = "owner_id", encoded = true) String ownerId,
                                           @Path(value = "repo_id", encoded = true) String repoId);

    @GET(Constants.COMMENTS_API)
    Observable<ArrayList<Comment>> getIssueComments(@HeaderMap Map<String, String> headerMap, @Path(value = "owner_id", encoded = true) String ownerId,
                                         @Path(value = "repo_id", encoded = true) String repoId, @Path(value = "issue_id", encoded = true) int issueId);

}
