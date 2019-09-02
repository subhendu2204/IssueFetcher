package com.gamechange.issuefetcher.utils;

public class CustomException extends Throwable{

    int errCode;
    String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public CustomException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
