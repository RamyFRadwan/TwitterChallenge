package com.challenger.ramyfradwan.twitterchallenge.API;


import com.challenger.ramyfradwan.twitterchallenge.Model.UserListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RamyFRadwan on 2/10/2018.
 */


public interface data {
    @GET("list.json")
    Call<UserListModel> getUserList(
//            @Query( "user_id") String user_id
//            cursor=-1&count=200&skip_status=true&include_user_entities=false&{user_id}
//            @Query("cursor") Integer cursor,
            @Query("user_id") Long user_id
//            @Query("count") Integer count,
//            @Query("skip_status") boolean skip_status,
//            @Query("include_user_entities") boolean include_user_entities
    );


}
