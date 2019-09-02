package com.gamechange.issuefetcher.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gamechange.issuefetcher.R;
import com.gamechange.issuefetcher.fragment.IssueFragment;
import com.gamechange.issuefetcher.model.Comment;
import com.gamechange.issuefetcher.model.Issue;
import com.gamechange.issuefetcher.presenter.IssueListPresenter;
import com.gamechange.issuefetcher.utils.Constants;
import com.gamechange.issuefetcher.viewInterface.IIssueList;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements IIssueList, IssueFragment.OnListFragmentInteractionListener {

    IssueListPresenter issueListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        issueListPresenter = new IssueListPresenter(this);
        issueListPresenter.getIssueList(Constants.ORG, Constants.USER);
    }


    @Override
    public void onFetchIssues(ArrayList<Issue> issues) {
        //set issue fragment to show issue list
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.issue_container, new IssueFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onFetchComments(ArrayList<Comment> comments) {
        if(comments == null || comments.size() == 0){
            //show dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_no_comment);
            builder.setPositiveButton(R.string.dialog_ok_btn, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            //set comment fragment to show issue list
            Intent intent = new Intent(this, CommentsActivity.class);
            intent.putParcelableArrayListExtra(Constants.FRAGMENT_KEY_COMMENT, comments);
            startActivity(intent);
        }
    }

    @Override
    public void onListFragmentInteraction(Issue item) {
        issueListPresenter.getCommentList(Constants.ORG, Constants.USER, item.getNumber());
    }
}
