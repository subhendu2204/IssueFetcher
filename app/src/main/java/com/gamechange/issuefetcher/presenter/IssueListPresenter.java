package com.gamechange.issuefetcher.presenter;

import android.widget.Toast;

import com.gamechange.issuefetcher.api.APIHandler;
import com.gamechange.issuefetcher.model.BaseRequest;
import com.gamechange.issuefetcher.model.Comment;
import com.gamechange.issuefetcher.model.Issue;
import com.gamechange.issuefetcher.storage.StorageManager;
import com.gamechange.issuefetcher.utils.Utils;
import com.gamechange.issuefetcher.viewInterface.IIssueList;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class IssueListPresenter {

    IIssueList view;
    CompositeSubscription subscriptions;

    public IssueListPresenter(IIssueList view){
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getIssueList(String ownerId, String repoId){

        view.showWait();
        ArrayList<Issue> issues = StorageManager.getInstance().getIssues();
        //first check cache expiry
        if(issues == null || Utils.isCacheExpired()){
            BaseRequest request = new BaseRequest();
            Subscription subscription = APIHandler.getAPIHandler().getIssueListSubscription(request, ownerId, repoId,
                    new APIHandler.SubscriptionCallback<ArrayList<Issue>>() {
                        @Override
                        public void onSuccess(ArrayList<Issue> response) {
                            //save to persistent storage
                            StorageManager.getInstance().saveIssues(response);
                            StorageManager.getInstance().saveCacheTime();
                            view.removeWait();
                            view.onFetchIssues(response);
                        }

                        @Override
                        public void onError(int errCode, String errMsg) {
                            view.removeWait();
                        }
                    });
            subscriptions.add(subscription);
        }else{
            view.removeWait();
            view.onFetchIssues(issues);
        }
    }

    public void getCommentList(String ownerId, String repoId, int issueId){

        view.showWait();
        BaseRequest request = new BaseRequest();
        Subscription subscription = APIHandler.getAPIHandler().getCommentsSubscription(request, ownerId, repoId, issueId,
                new APIHandler.SubscriptionCallback<ArrayList<Comment>>() {
                    @Override
                    public void onSuccess(ArrayList<Comment> response) {
                        view.removeWait();
                        view.onFetchComments(response);
                    }

                    @Override
                    public void onError(int errCode, String errMsg) {
                        view.removeWait();
                    }
                });
        subscriptions.add(subscription);
    }


}
