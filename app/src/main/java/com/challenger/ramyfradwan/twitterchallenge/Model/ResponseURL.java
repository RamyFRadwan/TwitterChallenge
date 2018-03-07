package com.challenger.ramyfradwan.twitterchallenge.Model;

/**
 * Created by RamyFRadwan on 3/7/2018.
 */

public class ResponseURL {
    private int cursor = -1;
    private int count = 200;
    private String user_id;
    private boolean skip_status,include_user_entities;

    public ResponseURL(int cusor, int count, String user_id, boolean skip_status, boolean include_user_entities){
        this.count = count;
        this.cursor = cusor;
        this.user_id = user_id;
        this.skip_status = skip_status;
        this.include_user_entities =include_user_entities;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isSkip_status() {
        return skip_status;
    }

    public void setSkip_status(boolean skip_status) {
        this.skip_status = skip_status;
    }

    public boolean isInclude_user_entities() {
        return include_user_entities;
    }

    public void setInclude_user_entities(boolean include_user_entities) {
        this.include_user_entities = include_user_entities;
    }
}
