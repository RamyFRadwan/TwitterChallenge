package com.challenger.ramyfradwan.twitterchallenge.Utilities;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.challenger.ramyfradwan.twitterchallenge.API.MyTwitterApiClient;
import com.challenger.ramyfradwan.twitterchallenge.DB.FollowersDB;
import com.challenger.ramyfradwan.twitterchallenge.DB.FollowersMetaDB;
import com.challenger.ramyfradwan.twitterchallenge.Model.FollowersModel;
import com.challenger.ramyfradwan.twitterchallenge.Model.UserModel;
import com.challenger.ramyfradwan.twitterchallenge.UI.FollowersActivityFragment;
import com.challenger.ramyfradwan.twitterchallenge.Adapter.MyFollowersRecyclerViewAdapter;
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

public class FetchTwitterUsersList extends AsyncTaskLoader<List<UserModel>> {
    private String TAG = getClass().getSimpleName();
    private Context context;
    private RecyclerView mview;
    private FollowersModel followers;
    private FollowersActivityFragment.OnListFragmentInteractionListener mListener;

    private FollowersDB followersDB;
    private FollowersMetaDB followersMetaDB;

    public FetchTwitterUsersList(Context context) {
        super(context);
    }

    public List<UserModel> getUserList
            (Long user_id
            , Context context
            , RecyclerView mView
            , FollowersActivityFragment.OnListFragmentInteractionListener mListener) {
        Log.i(FetchTwitterUsersList.class.getName() + "    Twitter USERNAME ", user_id.toString());
        this.mListener = mListener;
        this.context = context;
        this.mview = mView;

        return loadInBackground();

    }


    public void view(List<UserModel> followersModel) {
//        MyFollowersRecyclerViewAdapter myFollowersRecyclerViewAdapter = new MyFollowersRecyclerViewAdapter(followersModel, context, new FollowersActivityFragment.OnListFragmentInteractionListener() {
//            @Override
//            public void onListFragmentInteraction(UserModel item) {
//                Toast.makeText(context, "Hello from the other side", Toast.LENGTH_LONG).show();
//            }
//        });
//        myFollowersRecyclerViewAdapter.notifyDataSetChanged();
        if (mview != null) {


            if (followersModel!=null  ) {
                RecyclerView recyclerView = (RecyclerView) mview;
                if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(new MyFollowersRecyclerViewAdapter(followersModel,context,mListener));
                    Log.e(getClass().getSimpleName(), "Linear Adapter started from here");

                } else  if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    recyclerView.setLayoutManager(new GridLayoutManager(context,2));
                    recyclerView.setAdapter(new MyFollowersRecyclerViewAdapter(followersModel,context,mListener));

                    Log.e(getClass().getSimpleName(), "Grid Adapter started from here");

                }

            }

        } else
            Log.e(TAG + "  Error ", "mView Recycler view is null");
    }

    @Override
    public List<UserModel> loadInBackground() {
        final TwitterSession session = TwitterCore
                .getInstance()
                .getSessionManager()
                .getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();

        followersDB = new FollowersDB();
        followersMetaDB = new FollowersMetaDB();

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
                myTwitterApiClient.getCustomService().list(Long.valueOf(-1), id, 200, true, false)
                        .enqueue(new Callback<FollowersModel>() {

                            @Override
                            public void onResponse(Call<FollowersModel> call, Response<FollowersModel> response) {
                                Log.i("resp success Call " + TAG, "  " + call.request().toString());
                                Log.i("resp success RESP" + TAG, "  " + response.toString());

                                if (response.body() != null) {
                                    Log.i("resp success bodynonull", "  " + response.body().getUsers().get(0).getDescription());
                                    followers = response.body();
                                    if (followers != null && !followersMetaDB.isFilled()) {
                                        for(int i = 0 ; i <followers.getUsers().size(); i++){
                                            followersDB = new FollowersDB(followers.getUsers().get(i).getName(),followers.getUsers().get(i).getDescription(),followers.getUsers().get(i).getId());

                                            followersDB.save();

                                            if (i==followers.getUsers().size()-1)
                                                Log.i(getClass().getSimpleName() + "Database","DAta Inserted Succefully");
                                        }
                                        followersMetaDB = new FollowersMetaDB(followers.getUsers().size(),true);
                                        followersMetaDB.save();


                                    }
//                                    while ((followers != null ? followers.getNextCursor() : null) != Long.valueOf(0)) {
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
                                    view(followers != null ? followers.getUsers() : null);

                                }

                            }

                            @Override
                            public void onFailure(Call<FollowersModel> call, Throwable t) {
                                Log.i("resp failure", "  " + t.getMessage());
                                Log.i("resp failure", "  " + call.request().toString());


                            }
                        });

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("res_error failure", t.getMessage());

            }
        });


        if (followers != null) return followers.getUsers();
        else return new ArrayList<UserModel>();
    }


}
