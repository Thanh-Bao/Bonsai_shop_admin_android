package com.nonglam.baobaoshopadmin.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nonglam.baobaoshopadmin.model.GroupProduct;
import com.nonglam.baobaoshopadmin.model.User;
import com.nonglam.baobaoshopadmin.ui.LoginActivity;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIServices {

    Gson gson = new GsonBuilder().setLenient().create();




    APIServices apiServices = new Retrofit.Builder()
            .baseUrl("https://baobaoshop.live/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIServices.class);

    @POST("Users/login")
    Call<User> login(@Body User user);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("Products/Admin")
    Call<GroupProduct> getProducts(@Query("page") int page , @Header("Authorization") String token);


}
