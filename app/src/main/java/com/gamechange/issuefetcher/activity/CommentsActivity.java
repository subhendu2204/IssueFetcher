package com.gamechange.issuefetcher.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gamechange.issuefetcher.R;
import com.gamechange.issuefetcher.fragment.CommentFragment;
import com.gamechange.issuefetcher.fragment.IssueFragment;
import com.gamechange.issuefetcher.model.Comment;
import com.gamechange.issuefetcher.utils.Constants;

import java.util.ArrayList;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        showComments();
    }

    void showComments(){

        Intent intent = getIntent();
        ArrayList<Comment> comments = intent.getParcelableArrayListExtra(Constants.FRAGMENT_KEY_COMMENT);
        if(comments!= null){
            Log.d("SUBHENDU", "comments:: " + comments.size());
        }

        CommentFragment commentFragment = CommentFragment.newInstance(comments);
        //set comment fragment to show issue list
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.comment_container, commentFragment);
        fragmentTransaction.commit();
    }
}
