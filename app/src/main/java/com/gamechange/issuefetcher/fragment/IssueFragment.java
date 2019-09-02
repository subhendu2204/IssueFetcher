package com.gamechange.issuefetcher.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamechange.issuefetcher.R;
import com.gamechange.issuefetcher.model.Issue;
import com.gamechange.issuefetcher.storage.StorageManager;

import java.util.ArrayList;

public class IssueFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;

    ArrayList<Issue> issues;

    public IssueFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get data from persistent storage
        issues = StorageManager.getInstance().getIssues();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.issue_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if(issues != null){
                recyclerView.setAdapter(new IssueRecyclerViewAdapter(issues, mListener));
            }else{
                //TODO show empty message
            }
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Issue item);
    }
}
