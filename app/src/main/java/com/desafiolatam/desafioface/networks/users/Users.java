package com.desafiolatam.desafioface.networks.users;

import com.desafiolatam.desafioface.models.Developer;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Users {

    @POST("users")
    Call<Developer[]> get(@QueryMap Map<String, String> queryMap);
}