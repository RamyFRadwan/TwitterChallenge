package com.challenger.ramyfradwan.twitterchallenge.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RamyFRadwan on 2/10/2018.
 */

public class RetrofitClient {
    public Retrofit getInstance(){
      return   new Retrofit.Builder()
                .baseUrl("https://api.twitter.com/1.1/followers/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
