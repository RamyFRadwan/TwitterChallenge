package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.jianastrero.sweetmotherofsqlite.SweetSQLite;

/**
 * Created by RamyFRadwan on 3/15/2018.
 */

public class IDDB extends SweetSQLite {
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    long id;

    public IDDB(){super();
        setSubclassInstance(this);}

}
