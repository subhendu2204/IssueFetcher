package com.gamechange.issuefetcher.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.gamechange.issuefetcher.R;
import com.gamechange.issuefetcher.viewInterface.IBaseInterface;

public class BaseActivity extends AppCompatActivity implements IBaseInterface {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void showWait() {
        progressBar = findViewById(R.id.progressBar_cyclic);
        if(progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void removeWait() {
        progressBar = findViewById(R.id.progressBar_cyclic);
        if(progressBar != null){
            progressBar.setVisibility(View.GONE);
        }
    }
}
