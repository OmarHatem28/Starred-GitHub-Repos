package com.example.warhit.starredrepos.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warhit.starredrepos.Adapter.ReposAdapter;
import com.example.warhit.starredrepos.Model.GitHubResponse;
import com.example.warhit.starredrepos.Presenter.ReposPresenter;
import com.example.warhit.starredrepos.R;
import com.example.warhit.starredrepos.View.StarredReposView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StarredReposView{

    EditText userName;
    RecyclerView RV;
    ProgressBar progressBar;
    TextView empty;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.user);
        empty = findViewById(R.id.empty);
        progressBar = findViewById(R.id.indeterminateBar);
        RV=findViewById(R.id.RV);
        layoutManager=new LinearLayoutManager(this);
        RV.setLayoutManager(layoutManager);
    }

    public void getMyRepos(View view) {

        if ( userName.getText().toString().isEmpty() ){
            Toast.makeText(this,"Please Enter A Valid User Name",Toast.LENGTH_LONG).show();
            return;
        }

        ReposPresenter reposPresenter = new ReposPresenter(this);
        reposPresenter.getStarredRepos(userName.getText().toString());
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showStarredRepos(List<GitHubResponse> StarredRepos) {

        if ( StarredRepos.size() == 0 ){
            empty.setText("This User Doesn't have Starred Repositories");
        }
        else{
            empty.setText("");
        }
        ReposAdapter reposAdapter = new ReposAdapter(StarredRepos);
        RV.setAdapter(reposAdapter);
        reposAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);

    }
}
