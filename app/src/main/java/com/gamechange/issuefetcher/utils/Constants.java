package com.gamechange.issuefetcher.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Constants {


    public static final String BASE_URL = "https://api.github.com/";
    public static final String ISSUES_API = "/repos/{owner_id}/{repo_id}/issues";//https://api.github.com/repos/firebase/firebase-ios-sdk/issues
    public static final String COMMENTS_API = "/repos/{owner_id}/{repo_id}/issues/{issue_id}/comments";
    //https://api.github.com/repos/firebase/firebase-ios-sdk/issues/3228/comments

    public static final String USER = "firebase-ios-sdk";
    public static final String ORG = "firebase";

    public static ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);

    public static final long READ_TIMEOUT = 30;
    public static final long CONNECT_TIMEOUT = 30;


    public static final String FRAGMENT_KEY_COMMENT = "FRAGMENT_KEY_COMMENT";

    public static final int ERR_CODE_NO_NETWORK = 1001;
    public static final int ERR_CODE_OTHER_ERR = 1002;

    public static final String ERR_MSG_NO_NETWORK = "Please Check your network Connection";

}
