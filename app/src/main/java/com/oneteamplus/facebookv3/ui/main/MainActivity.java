package com.oneteamplus.facebookv3.ui.main;

import static androidx.lifecycle.ViewModelProvider.*;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import com.oneteamplus.facebookv3.R;
import com.oneteamplus.facebookv3.pojo.PostModel;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.nio.file.Path;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        postViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(PostViewModel.class);
        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        postViewModel.postsMutableLiveData.observe(this, adapter::setList);
    }
    //postViewModel = new ViewModelProvider(this,
    //                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
    //                .get(PostViewModel.class);
}