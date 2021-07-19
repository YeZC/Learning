package com.yzc.retrofit2;

import com.example.learningmaterials.源码解析.retrofit2.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        Call<List<Repo>> call =  service.listRepos("octocat");

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response != null){
                    List<Repo> repos = response.body();
                    System.out.println("repo name:" + repos.get(0).getName());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
