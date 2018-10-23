package com.example.warhit.starredrepos.Presenter;

import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.example.warhit.starredrepos.Model.GitHubResponse;
import com.example.warhit.starredrepos.Retrofit.GitHubClient;
import com.example.warhit.starredrepos.Retrofit.GitHubRequest;
import com.example.warhit.starredrepos.View.StarredReposView;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class ReposPresenter {

    StarredReposView starredReposView;
    public ReposPresenter( StarredReposView starredReposView){
        this.starredReposView = starredReposView;
    }

    public void getStarredRepos(String userName){
        GitHubRequest gitHubRequest = GitHubClient.getInstance().create(GitHubRequest.class);

        Observable<List<GitHubResponse>> observable = gitHubRequest.getStarredRepos(userName);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitHubResponse>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onNext(List<GitHubResponse> gitHubResponses) {
                        Log.d(TAG, "In onNext()");
//                        adapter.setGitHubRepos(gitHubRepos);
                    }
                });
    }

}
