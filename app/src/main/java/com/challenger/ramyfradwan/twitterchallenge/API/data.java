package com.challenger.ramyfradwan.twitterchallenge.API;



import com.challenger.ramyfradwan.twitterchallenge.Model.ResponseURL;
import com.challenger.ramyfradwan.twitterchallenge.Model.UserListModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by RamyFRadwan on 2/10/2018.
 */


public interface data {
    @GET("list.json?")
    Call<ArrayList<UserListModel>> getUserList(@Body ResponseURL responseUrl);


}
