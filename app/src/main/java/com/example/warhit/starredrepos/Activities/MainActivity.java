package com.example.warhit.starredrepos.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.warhit.starredrepos.R;

public class MainActivity extends AppCompatActivity {

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
    }
}
