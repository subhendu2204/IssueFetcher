package com.gamechange.issuefetcher.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gamechange.issuefetcher.R;
import com.gamechange.issuefetcher.model.Comment;

import java.util.ArrayList;

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder>{
    private final ArrayList<Comment> mValues;

    public CommentRecyclerViewAdapter(ArrayList<Comment> items) {
        mValues = items;
    }

    @Override
    public CommentRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        return new CommentRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTitleView.setText(mValues.get(position).getUser().getLogin());
        holder.mContentView.setText(mValues.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.comment_author);
            mContentView = (TextView) view.findViewById(R.id.comment_content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
