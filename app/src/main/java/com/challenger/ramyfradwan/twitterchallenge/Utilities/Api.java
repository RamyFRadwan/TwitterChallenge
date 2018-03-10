package com.challenger.ramyfradwan.twitterchallenge.Utilities;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RamyFRadwan on 3/10/2018.
 */

public interface Api {
    @GET("/1.1/followers/list.json")
    Call<ResponseBody> list(@Query("user_id") long id);
}