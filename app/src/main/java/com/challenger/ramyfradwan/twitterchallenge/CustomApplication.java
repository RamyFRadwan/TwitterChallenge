package com.challenger.ramyfradwan.twitterchallenge;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

/**
 * Created by RamyFRadwan on 3/6/2018.
 */
public class CustomApplication extends Application {
    public void onCreate() {
        super.onCreate();
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(Constants.getSakalassa(), Constants.getSakalassaa())).build();

        Twitter.initialize(config);
    }
}
