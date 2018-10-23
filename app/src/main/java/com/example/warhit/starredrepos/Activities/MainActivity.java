package com.example.warhit.starredrepos.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.warhit.starredrepos.Adapter.ReposAdapter;
import com.example.warhit.starredrepos.Model.GitHubResponse;
import com.example.warhit.starredrepos.Presenter.ReposPresenter;
import com.example.warhit.starredrepos.R;
import com.example.warhit.starredrepos.View.StarredReposView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StarredReposView{

    EditText userName;
    RecyclerView RV;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.user);
        RV=findViewById(R.id.RV);
        layoutManager=new LinearLayoutManager(this);
        RV.setLayoutManager(layoutManager);
    }

    public void getMyRepos(View view) {

        ReposPresenter reposPresenter = new ReposPresenter(this);
        reposPresenter.getStarredRepos(userName.getText().toString());

    }

    @Override
    public void showStarredRepos(List<GitHubResponse> StarredRepos) {

        ReposAdapter reposAdapter = new ReposAdapter(StarredRepos);
        RV.setAdapter(reposAdapter);
        reposAdapter.notifyDataSetChanged();

    }
}
