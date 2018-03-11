package com.challenger.ramyfradwan.twitterchallenge.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.challenger.ramyfradwan.twitterchallenge.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Login Button initializing for authentication
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                Log.i("Twitter Session" , "Login button session connection state is : SUCCESS");
                String username = result.data.getUserName();
                Long user_id = result.data.getUserId();
                Log.i("Twitter Session" , "Twitter username is : " + username);
                Log.i("Twitter Session", "Twitter user_id is : " + user_id);

                //Using Shared preferences for keeping login state
                //User has successfully logged in, save this information
                // We need an Editor object to make preference changes.
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode

                SharedPreferences.Editor editor = settings.edit();

                //Set "hasLoggedIn" to true
                editor.putBoolean("hasLoggedIn", true);
                editor.putString("username", username);
                editor.putLong("user_id", user_id);

                // Commit the edits!
                editor.commit();


            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.i("Twitter Session", "Login button session connection state is : Failed");


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Pass the activity result to the login button.
        super.onActivityResult(requestCode, resultCode, data);


        Intent intent = new Intent(getBaseContext(),FollowersActivity.class);
        startActivity(intent);
        loginButton.onActivityResult(requestCode, resultCode, data);

    }
}
