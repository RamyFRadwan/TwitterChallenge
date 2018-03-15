package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by RamyFRadwan on 3/15/2018.
 */
@Table
public class FollowersMetaDB extends SugarRecord {


    private int userCount;
    private boolean filled;

    public FollowersMetaDB(){}
    public FollowersMetaDB(int userCount, boolean filled){
        this.filled = filled;
        this.userCount =userCount;
    }




    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

}
