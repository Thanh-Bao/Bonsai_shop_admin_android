package com.nonglam.baobaoshopadmin.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nonglam.baobaoshopadmin.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface APIServices {

    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

    APIServices apiServices = new Retrofit.Builder()
            .baseUrl("https://baobaoshop.live/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIServices.class);

    @POST("Users/login")
    Call<User> login(@Body User user);

}
