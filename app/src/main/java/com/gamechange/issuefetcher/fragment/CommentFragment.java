package com.gamechange.issuefetcher.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamechange.issuefetcher.R;
import com.gamechange.issuefetcher.model.Comment;
import com.gamechange.issuefetcher.utils.Constants;

import java.util.ArrayList;

public class CommentFragment extends Fragment {
    private IssueFragment.OnListFragmentInteractionListener mListener;

    ArrayList<Comment> comments;

    public CommentFragment() {
    }

    public static CommentFragment newInstance(ArrayList<Comment> comments){
        CommentFragment commentFragment = new CommentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constants.FRAGMENT_KEY_COMMENT, comments);
        commentFragment.setArguments(bundle);
        return commentFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get data from persistent storage
        comments = getArguments().getParcelableArrayList(Constants.FRAGMENT_KEY_COMMENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if(comments != null && comments.size()>0){
                recyclerView.setAdapter(new CommentRecyclerViewAdapter(comments));
            }else{
                //TODO show empty message
                Log.d("SUBHENDU", "Comment EMPTY");
            }
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
