package com.example.learningmaterials.源码解析.retrofit2;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @Nullable
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
