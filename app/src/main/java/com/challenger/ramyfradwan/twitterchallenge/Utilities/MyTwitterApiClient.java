package com.challenger.ramyfradwan.twitterchallenge.Utilities;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by RamyFRadwan on 3/10/2018.
 */
public class MyTwitterApiClient extends TwitterApiClient {
    public MyTwitterApiClient(TwitterSession session) {
        super(session);
    }

    /**
     * Provide CustomService with defined endpoints
     */
    public Api getCustomService() {
        return getService(Api.class);
    }
}
