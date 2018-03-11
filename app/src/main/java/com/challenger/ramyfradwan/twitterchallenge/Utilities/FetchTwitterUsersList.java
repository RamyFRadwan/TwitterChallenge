package com.challenger.ramyfradwan.twitterchallenge.Utilities;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.challenger.ramyfradwan.twitterchallenge.API.MyTwitterApiClient;
import com.challenger.ramyfradwan.twitterchallenge.Model.FollowersModel;
import com.challenger.ramyfradwan.twitterchallenge.UI.FollowersActivityFragment;
import com.challenger.ramyfradwan.twitterchallenge.UI.MyFollowersRecyclerViewAdapter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RamyFRadwan on 3/7/2018.
 */

public class FetchTwitterUsersList {
    String TAG = getClass().getSimpleName();
    FollowersModel followers;
    private Context context;
    private RecyclerView mview;

    public List<com.challenger.ramyfradwan.twitterchallenge.Model.User> getUserList(Long user_id, Context context, RecyclerView mView) {
        Log.i(FetchTwitterUsersList.class.getName() + "    Twitter USERNAME ", user_id.toString());

        this.context = context;
        this.mview = mView;
//
        final TwitterSession session = TwitterCore
                .getInstance()
                .getSessionManager()
                .getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();


        //Here we get all the details of user's twitter account

        Call<User> userCall = TwitterCore.getInstance().getApiClient(session).getAccountService()
                .verifyCredentials(true, false, false);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("resp  " + TAG, "  " + response.body().followersCount);

                User user = response.body();
                final long id = user.id;
                Log.i("resp " + FetchTwitterUsersList.this.getClass().getSimpleName(), "  " + user.id);

                Long cursor = Long.valueOf(-1);
                final MyTwitterApiClient myTwitterApiClient = new MyTwitterApiClient(session);
                myTwitterApiClient.getCustomService().list(Long.valueOf(-1), id, 20, true, false)
                        .enqueue(new Callback<FollowersModel>() {

                            @Override
                            public void onResponse(Call<FollowersModel> call, Response<FollowersModel> response) {
                                Log.i("resp success Call " + TAG, "  " + call.request().toString());
                                Log.i("resp success RESP" + TAG, "  " + response.toString());

                                if (response.body() != null) {
                                    Log.i("resp success bodynonull", "  " + response.body().getUsers().get(0).getDescription());
                                    followers = response.body();
//                                    while (followers.getNextCursor() != Long.valueOf(0)) {
//                                        myTwitterApiClient.getCustomService().list(followers.getNextCursor(), id, 20, true, false)
//                                                .enqueue(new Callback<FollowersModel>() {
//
//                                                    @Override
//                                                    public void onResponse(Call<FollowersModel> call, Response<FollowersModel> response) {
//                                                        Log.i("resp success loop", "  " + response.body().getUsers().get(0).getDescription());
//                                                        followers = response.body();
//                                            view(followers.getUsers());
//
//
//                                                    }
//
//                                                    @Override
//                                                    public void onFailure(Call<FollowersModel> call, Throwable t) {
//                                                        Log.i("resp failure", "  " + t.getMessage());
//                                                        Log.i("resp failure", "  " + call.request().toString());
//
//
//                                                    }
//                                                });
//
//
//                                    }
                                    view(followers.getUsers());
                                }

                            }

                            @Override
                            public void onFailure(Call<FollowersModel> call, Throwable t) {
                                Log.i("resp failure", "  " + t.getMessage());
                                Log.i("resp failure", "  " + call.request().toString());


                            }
                        });

//                FollowersModels = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("res_error failure", t.getMessage());

            }
        });


        if(followers!=null) return followers.getUsers();
        else return new ArrayList<com.challenger.ramyfradwan.twitterchallenge.Model.User>();

    }


    public void view(List<com.challenger.ramyfradwan.twitterchallenge.Model.User> followersModel) {
        MyFollowersRecyclerViewAdapter myFollowersRecyclerViewAdapter = new MyFollowersRecyclerViewAdapter(followersModel, context, new FollowersActivityFragment.OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(com.challenger.ramyfradwan.twitterchallenge.Model.User item) {
                Toast.makeText(context, "Hello from the other side", Toast.LENGTH_LONG).show();
            }
        });
        myFollowersRecyclerViewAdapter.notifyDataSetChanged();
        if (mview != null) {
            Log.e(TAG, "Adapter started from here");
            LinearLayoutManager llm = new LinearLayoutManager(context);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            mview.setLayoutManager(llm);

            mview.setAdapter(myFollowersRecyclerViewAdapter);

        } else
            Log.e(TAG + "  Error ", "mView Recycler view is null");
    }
}
