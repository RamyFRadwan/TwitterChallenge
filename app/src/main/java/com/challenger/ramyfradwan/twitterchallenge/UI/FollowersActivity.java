package com.challenger.ramyfradwan.twitterchallenge.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.challenger.ramyfradwan.twitterchallenge.Model.User;
import com.challenger.ramyfradwan.twitterchallenge.R;
import com.challenger.ramyfradwan.twitterchallenge.Utilities.FetchTwitterUsersList;

public class FollowersActivity extends AppCompatActivity implements FollowersActivityFragment.OnListFragmentInteractionListener {
    public static final String PREFS_NAME = "MyPrefsFile";
    boolean hasLoggedIn;
    String user_id;
    Long user_Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        user_id = settings.getString("username", "");
        user_Id = settings.getLong("user_id", 0);

        Log.i(this.getClass().getName(), "Login status is : " + hasLoggedIn + "");

        Log.i(this.getClass().getName(), "User Name is : " + user_id);

        Log.i(this.getClass().getName(), "User ID is : " + user_Id);
        if(!hasLoggedIn)
        {
            //Go directly to main activity.
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
//            finish();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onListFragmentInteraction(User item) {

    }
}
