package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.jianastrero.sweetmotherofsqlite.SweetSQLite;

/**
 * Created by RamyFRadwan on 3/15/2018.
 */

public class FilledDB extends SweetSQLite {
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    boolean filled;
public FilledDB(){super();
    setSubclassInstance(this);}
}
