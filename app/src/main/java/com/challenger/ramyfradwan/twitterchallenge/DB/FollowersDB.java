package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.jianastrero.sweetmotherofsqlite.SweetSQLite;

/**
 * Created by RamyFRadwan on 3/14/2018.
 */

public class FollowersDB extends SweetSQLite {


    public FollowersDB(){
        super();
        setSubclassInstance(this);
    }
}
