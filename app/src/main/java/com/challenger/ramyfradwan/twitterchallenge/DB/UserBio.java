package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.jianastrero.sweetmotherofsqlite.SweetSQLite;

/**
 * Created by RamyFRadwan on 3/15/2018.
 */

public class UserBio extends SweetSQLite {
    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    String Bio;

    public UserBio(){super();
        setSubclassInstance(this);}

}
