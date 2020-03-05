package com.shubham.introretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import java.util.List;

class GitHubRepoAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<GitHubRepo> repos;
    GitHubRepoAdapter(Context context, int resource, List<GitHubRepo> repos) {
        super(context, 0, repos);
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.list_item,null);
        }
        TextView name = (TextView)view.findViewById(R.id.textview);

        GitHubRepo gitHubRepo = repos.get(position);
        if(name != null)
        {
            name.setText(gitHubRepo.getName());
        }

        return view;
    }
}