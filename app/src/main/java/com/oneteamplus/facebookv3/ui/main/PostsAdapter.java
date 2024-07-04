package com.oneteamplus.facebookv3.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oneteamplus.facebookv3.R;
import com.oneteamplus.facebookv3.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    private List<PostModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        PostModel post = postsList.get(position);
        holder.title.setText(post.getTitle());
        holder.id.setText(String.valueOf(post.getUserId()));
        holder.body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setList(List<PostModel> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        TextView body;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTV);
            id = itemView.findViewById(R.id.userIDTV);
            body = itemView.findViewById(R.id.bodyTV);
        }
    }
}