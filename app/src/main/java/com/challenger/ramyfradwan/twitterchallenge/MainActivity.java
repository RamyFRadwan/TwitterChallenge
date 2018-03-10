package com.challenger.ramyfradwan.twitterchallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.challenger.ramyfradwan.twitterchallenge.Utilities.FetchTwitterUsersList;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        String user_id = settings.getString("username", "");
        Long user_Id = settings.getLong("user_id", 0);

        Log.i(this.getClass().getName(), "Login status is : " + hasLoggedIn + "");

        Log.i(this.getClass().getName(), "User Name is : " + user_id);

        Log.i(this.getClass().getName(), "User ID is : " + user_Id);

        FetchTwitterUsersList fetchTwitterUsersList = new FetchTwitterUsersList();
        if(!hasLoggedIn)
        {
            //Go directly to main activity.
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            MainActivity.this.finish();
        } else if (hasLoggedIn)
            fetchTwitterUsersList.getUserList(user_Id);

    }



}
