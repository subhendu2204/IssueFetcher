package com.gamechange.issuefetcher.api;

import android.util.Log;

import com.gamechange.issuefetcher.model.BaseRequest;
import com.gamechange.issuefetcher.model.Issue;
import com.gamechange.issuefetcher.utils.Constants;
import com.gamechange.issuefetcher.utils.CustomException;
import com.gamechange.issuefetcher.utils.Utils;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class APIHandler {

    private IRetrofitAPI apiClient;
    private static APIHandler apiHandler;

    private APIHandler(){
        apiClient = APIClient.getAPIClient(Constants.BASE_URL, IRetrofitAPI.class);
    }

    public static APIHandler getAPIHandler(){
        if(apiHandler == null){
            apiHandler = new APIHandler();
        }
        return apiHandler;
    }

    public Subscription getIssueListSubscription(BaseRequest request, String owner, String repo,SubscriptionCallback<ArrayList<Issue>> callback){
        return getSubscription(apiClient.getIssues(request.headerMap, owner, repo), callback);
    }

    public Subscription getCommentsSubscription(BaseRequest request, String owner, String repo, int issueId, SubscriptionCallback callback){
        return getSubscription(apiClient.getIssueComments(request.headerMap, owner, repo, issueId), callback);
    }


    private <T>Subscription getSubscription(Observable<T> observable, final SubscriptionCallback<T> callback){
        if(!Utils.isNetworkAvailable()){
            observable = Observable.error(new CustomException(Constants.ERR_CODE_NO_NETWORK, Constants.ERR_MSG_NO_NETWORK));
        }

        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e instanceof CustomException){
                            callback.onError(((CustomException) e).getErrCode(), ((CustomException) e).getErrMsg());
                        }else{
                            callback.onError(Constants.ERR_CODE_OTHER_ERR, e.getMessage());
                            Log.d("SUBHENDU", "API HANDLER:: " + e.getMessage());
                        }

                    }

                    @Override
                    public void onNext(T t) {
                        callback.onSuccess(t);
                    }
                });

    }

    public interface SubscriptionCallback<T>{
        void onSuccess(T response);
        void onError(int errCode, String errMsg);
    }
}
