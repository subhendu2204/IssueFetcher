package com.gamechange.issuefetcher.api;

import com.gamechange.issuefetcher.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class APIClient {

    private static OkHttpClient getHttpClient(){

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        //add logging interceptor to get http logs
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(httpLoggingInterceptor);

        //set connection timeout
        client.readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS);
        client.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);

        return client.build();

    }


    private static Retrofit getRetrofitClient(String baseUrl){
        return new Retrofit.Builder().baseUrl(baseUrl).client(getHttpClient())
                .addConverterFactory(JacksonConverterFactory.create(Constants.OBJECT_MAPPER))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }

    public static <T> T getAPIClient(String baseUrl, Class<T> apiInterface){
        return getRetrofitClient(baseUrl).create(apiInterface);
    }

}
