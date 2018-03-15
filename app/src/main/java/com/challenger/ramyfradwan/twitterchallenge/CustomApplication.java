package com.challenger.ramyfradwan.twitterchallenge;

import android.app.Application;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import com.challenger.ramyfradwan.twitterchallenge.Utilities.Constants;

import com.orm.SugarApp;
import com.orm.SugarContext;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by RamyFRadwan on 3/6/2018.
 */
public class CustomApplication extends SugarApp {
    public void onCreate() {
        super.onCreate();

        SugarContext.init(getApplicationContext());
        //        SweetSQLiteConfig.init(this, "UsersOfflineDB");

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(Constants.getSakalassa(), Constants.getSakalassaa())).build();

        Twitter.initialize(config);
        final TwitterSession activeSession = TwitterCore.getInstance()
                .getSessionManager().getActiveSession();

        // example of custom OkHttpClient with logging HttpLoggingInterceptor
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        final OkHttpClient customClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();

        // pass custom OkHttpClient into TwitterApiClient and add to TwitterCore
        final TwitterApiClient customApiClient;
        if (activeSession != null) {
            customApiClient = new TwitterApiClient(activeSession, customClient);
            TwitterCore.getInstance().addApiClient(activeSession, customApiClient);
        } else {
            customApiClient = new TwitterApiClient(customClient);
            TwitterCore.getInstance().addGuestApiClient(customApiClient);
        }
    }
}
