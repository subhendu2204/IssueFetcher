package com.gamechange.issuefetcher.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gamechange.issuefetcher.model.Issue;
import com.gamechange.issuefetcher.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class StorageManager {

    private static StorageManager storageManager;
    private SPHelper spHelper;

    private StorageManager(){
        spHelper = SPHelper.getInstance();
    }

    public static StorageManager getInstance(){
        if(storageManager == null){
            storageManager = new StorageManager();
        }
        return storageManager;
    }

    public void saveIssues(ArrayList<Issue> issues){
        try {
            Collections.sort(issues, Issue.COMPARE_BY_UPDATED_DATE);
            String issuesString = Constants.OBJECT_MAPPER.writeValueAsString(issues);
            spHelper.saveString(SPHelper.ISSUE_LIST, issuesString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Issue> getIssues(){
        String issueString = spHelper.getString(SPHelper.ISSUE_LIST);
        if(issueString != null){
            try {
                Issue[] issues =  Constants.OBJECT_MAPPER.readValue(issueString, Issue[].class);
                ArrayList<Issue> issueList = new ArrayList<>();
                for (Issue issue: issues) {
                    issueList.add(issue);
                }
                return issueList;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void saveCacheTime(){
        //save current time
        spHelper.saveLong(SPHelper.CACHE_TIME, Calendar.getInstance().getTimeInMillis());
    }

    public long getCacheTime(){
        return spHelper.getLong(SPHelper.CACHE_TIME);
    }
}
