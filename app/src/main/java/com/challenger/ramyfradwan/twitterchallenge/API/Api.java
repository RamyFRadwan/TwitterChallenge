package com.challenger.ramyfradwan.twitterchallenge.API;

import com.challenger.ramyfradwan.twitterchallenge.Model.FollowersModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RamyFRadwan on 3/10/2018.
 */

public interface Api {
    @GET("/1.1/followers/list.json")
    Call<FollowersModel> list(
            @Query("cursor") Long cursor,
            @Query("user_id") Long user_id,
            @Query("count") Integer count,
            @Query("skip_status") boolean skip_status,
            @Query("include_user_entities") boolean include_user_entities
    );
}