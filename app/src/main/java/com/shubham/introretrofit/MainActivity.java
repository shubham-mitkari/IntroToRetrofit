package com.shubham.introretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);


        SharedPreferences settings = getApplicationContext().getSharedPreferences("Login call processing", Context.MODE_PRIVATE);
        String authToken = settings.getString("auth_token", "");
        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubService client = RetrofitClient.createService(GitHubService.class);

        // Fetch a list of the Github repositories.
        Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");
        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                List<GitHubRepo> repos = response.body();
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this,0,  repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });
    }
}
