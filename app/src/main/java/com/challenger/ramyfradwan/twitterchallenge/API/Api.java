package com.challenger.ramyfradwan.twitterchallenge.API;

import com.challenger.ramyfradwan.twitterchallenge.Model.FollowersModel;
import com.challenger.ramyfradwan.twitterchallenge.Model.TweetListModel;

import java.util.List;

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

    @GET("/1.1/statuses/user_timeline.json")
    Call<List<TweetListModel>> list(
            @Query("screen_name") String screen_name,
            @Query("count") int count,
            @Query("exclude_replies") boolean include_entities,
            @Query("include_rts") boolean include_rts
            
    )
            ;
}