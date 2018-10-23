package com.example.warhit.starredrepos.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient {

    private static GitHubClient singlton;
    private static GitHubRequest gitHubRequest;
    private static Retrofit retrofit = null;

    private static final String GITHUB_BASE_URL = "https://api.github.com/";

    private GitHubClient(){
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

//        gitHubRequest = retrofit.create(GitHubRequest.class);
    }

    public static Retrofit getInstance(){
        if ( singlton == null ){
            singlton = new GitHubClient();
        }
        return retrofit;
    }

}
