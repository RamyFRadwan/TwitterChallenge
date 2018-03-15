package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.jianastrero.sweetmotherofsqlite.SweetSQLite;

/**
 * Created by RamyFRadwan on 3/15/2018.
 */

public class UserCountDB extends SweetSQLite {
    public int getUsersCounter() {
        return usersCounter;
    }

    public void setUsersCounter(int usersCounter) {
        this.usersCounter = usersCounter;
    }

    int usersCounter;
    public UserCountDB(){super();
        setSubclassInstance(this);}
}
