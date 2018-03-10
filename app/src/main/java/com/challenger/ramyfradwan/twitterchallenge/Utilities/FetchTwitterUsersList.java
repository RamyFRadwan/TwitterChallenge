package com.challenger.ramyfradwan.twitterchallenge.Utilities;

import android.util.Log;

import com.challenger.ramyfradwan.twitterchallenge.Model.ResponseURL;
import com.challenger.ramyfradwan.twitterchallenge.Model.UserListModel;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RamyFRadwan on 3/7/2018.
 */

public class FetchTwitterUsersList {

    static ResponseURL responseURL;
    static ArrayList<UserListModel> userListModels;

    //    private static Long user_id;
    public void getUserList(Long user_id) {
        Log.i(FetchTwitterUsersList.class.getName() + "    Twitter USERNAME ", user_id.toString());

//
        final TwitterSession session = TwitterCore
                .getInstance()
                .getSessionManager()
                .getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();
        String token = authToken.token;
        String secret = authToken.secret;

        //Here we get all the details of user's twitter account
//        RetrofitClient client = new RetrofitClient();
//        Retrofit retrofit = client.getInstance();
//        data data = retrofit.create(data.class);
//        Call<UserListModel> call = data.getUserList(-1,user_id,42, false,false);
//        Call<UserListModel> call = data.getUserList(user_id);
//        Call<User> userCall= TwitterCore.getInstance().getApiClient(session).getAccountService()
//                .verifyCredentials(false, false,false);
        Call<User> userCall = TwitterCore.getInstance().getApiClient(session).getAccountService()
                .verifyCredentials(false, false, false);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                MyTwitterApiClient myTwitterApiClient = new MyTwitterApiClient(session);
                myTwitterApiClient.getCustomService().list(response.body().id).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.i("resp", "  " + response.toString());

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

//                userListModels = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("res_error", t.getMessage());

            }
        });
    }
}
