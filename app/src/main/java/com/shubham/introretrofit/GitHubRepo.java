package com.shubham.introretrofit;

public class GitHubRepo {
    public int id;
    public String name;

    public GitHubRepo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
