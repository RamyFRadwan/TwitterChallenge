package com.challenger.ramyfradwan.twitterchallenge.DB;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by RamyFRadwan on 3/14/2018.
 */
@Table
public class FollowersDB extends SugarRecord {

    public FollowersDB(){
        super();

    }

    public FollowersDB(String ScreenName,
                       String userBio,
                       long userId){
        super();
        this.screenName = ScreenName;
        this.userBio = userBio;
        this.userId = userId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    private String screenName;


    public Long getId() {
        return userId;
    }


    public void setId(long id) {
        this.userId = id;
    }

    private long userId;

    public String getBio() {
        return userBio;
    }

    public void setBio(String bio) {
        userBio = bio;
    }

    private String userBio;



}
