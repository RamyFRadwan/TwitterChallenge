package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.jianastrero.sweetmotherofsqlite.SweetSQLite;

/**
 * Created by RamyFRadwan on 3/15/2018.
 */

public class UserNameDB extends SweetSQLite {
    public String getScreenName() {
        return ScreenName;
    }

    public void setScreenName(String screenName) {
        ScreenName = screenName;
    }

    String ScreenName;

    public UserNameDB(){super();
        setSubclassInstance(this);}
}
