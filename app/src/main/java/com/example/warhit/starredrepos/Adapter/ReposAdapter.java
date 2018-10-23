package com.example.warhit.starredrepos.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.warhit.starredrepos.Model.GitHubResponse;
import com.example.warhit.starredrepos.R;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoHolder> {

    List<GitHubResponse> repositories;

    public ReposAdapter( List<GitHubResponse> repositories ){
        this.repositories = repositories;
    }


    @NonNull
    @Override
    public RepoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo,parent,false);
        return new RepoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoHolder holder, int position) {
        GitHubResponse repo = repositories.get(position);
        holder.repoName.setText(repo.getName());
        holder.repoDescription.setText(repo.getDescription());
        holder.language.setText(repo.getLanguage());
        holder.stars.setText(repo.getStargazersCount()+"");
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class RepoHolder extends RecyclerView.ViewHolder{

        TextView repoName;
        TextView repoDescription;
        TextView language;
        TextView stars;

        public RepoHolder(View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repo_name);
            repoDescription = itemView.findViewById(R.id.repo_description);
            language = itemView.findViewById(R.id.language);
            stars = itemView.findViewById(R.id.stars);

        }
    }

}
