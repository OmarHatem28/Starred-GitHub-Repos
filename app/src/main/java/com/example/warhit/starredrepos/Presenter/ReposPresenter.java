package com.example.warhit.starredrepos.Presenter;

import android.telecom.Call;

import com.example.warhit.starredrepos.Model.GitHubResponse;
import com.example.warhit.starredrepos.Retrofit.GitHubClient;
import com.example.warhit.starredrepos.Retrofit.GitHubRequest;
import com.example.warhit.starredrepos.View.StarredReposView;

import java.util.List;

import rx.Observable;

public class ReposPresenter {

    StarredReposView starredReposView;
    public ReposPresenter( StarredReposView starredReposView){
        this.starredReposView = starredReposView;
    }

    public void getStarredRepos(String userName){
        GitHubRequest gitHubRequest = GitHubClient.getInstance().create(GitHubRequest.class);

        Observable<List<GitHubResponse>> call = gitHubRequest.getStarredRepos(userName);
    }

}
