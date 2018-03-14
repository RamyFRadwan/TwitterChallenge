package com.challenger.ramyfradwan.twitterchallenge.UI;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.challenger.ramyfradwan.twitterchallenge.Model.UserModel;
import com.challenger.ramyfradwan.twitterchallenge.R;

public class ProfileActivity extends AppCompatActivity implements ProfileActivityFragment.OnListFragmentInteractionListener {
    public static final String PREFS_NAME = "MyPrefsFile";

    private String screen_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
        this.screen_name = settings.getString("screenname"," ");
        toolbar.setTitle("@"+this.screen_name);
//        setSupportActionBar(toolbar);




    }

    @Override
    public void onListFragmentInteraction() {

    }
}
