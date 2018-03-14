package com.challenger.ramyfradwan.twitterchallenge.Utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.widget.ListView;

import com.challenger.ramyfradwan.twitterchallenge.API.MyTwitterApiClient;
import com.challenger.ramyfradwan.twitterchallenge.Adapter.TweetListAdapter;
import com.challenger.ramyfradwan.twitterchallenge.Model.TweetListModel;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RamyFRadwan on 3/13/2018.
 */

public class FetchTwitterProfile extends AsyncTaskLoader<List<String>> {
    private String screenName;
     List<String> tweets = new ArrayList<>();
    public static final String PREFS_NAME = "MyPrefsFile";
    private ListView listView;
    private TweetListAdapter tweetListAdapter;
    private Context context;
    public FetchTwitterProfile(@NonNull Context context, String screen_name, ListView listView) {
        super(context);

        this.context = context;

        this.screenName = screen_name;
        this.listView = listView;

        List<String> tweeets = loadInBackground();
        if (tweeets != null) {
            Log.i(getClass().getSimpleName() + "  Tweets", tweeets.toString());
        }else
            Log.i(getClass().getSimpleName() + "  Tweets", "No Tweets received");



    }



    @Nullable
    @Override
    public List<String> loadInBackground() {

        final TwitterSession session = TwitterCore
                .getInstance()
                .getSessionManager().getActiveSession();

        //Here we get all the details of user's twitter account
        Log.i(getClass().getSimpleName() + "  Screen Name" , screenName);

        MyTwitterApiClient myTwitterApiClient = new MyTwitterApiClient(session);
        Call<List<TweetListModel>> userCall = myTwitterApiClient.getCustomService().list(screenName,10,true,false);
//                TwitterCore.getInstance().getApiClient(session).getListService().statuses(null,"Egypt",screenName,userId,null,null,10,false,false);
        userCall.enqueue(new Callback<List<TweetListModel>>() {
            @Override
            public void onResponse(Call<List<TweetListModel>> call, Response<List<TweetListModel>> response) {
                if (response.body()!= null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        tweets.add(response.body().get(i).getText());
                    }
                    Log.i(getClass().getSimpleName() + "Tweet List", tweets.toString());
                }else tweets.add("Sorry no tweets retrieved for this user");
                tweetListAdapter =  new TweetListAdapter((ArrayList)tweets,context);
                listView.setAdapter(tweetListAdapter);
            }

            @Override
            public void onFailure(Call<List<TweetListModel>> call, Throwable t) {
                Log.e(getClass().getSimpleName() + "  failure" , call.toString());
                Log.e(getClass().getSimpleName() + "  failure" , t.toString());


            }
        });
        Log.i(getClass().getSimpleName() + "Tweet List", tweets.toString());

        return tweets;
    }
}
