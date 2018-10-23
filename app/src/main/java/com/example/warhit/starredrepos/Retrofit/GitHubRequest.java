package com.example.warhit.starredrepos.Retrofit;

import com.example.warhit.starredrepos.Model.GitHubResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface GitHubRequest {

    @GET("users/{user}/starred")
    Observable<List<GitHubResponse>> getStarredRepos(@Path("user") String userName);

}
