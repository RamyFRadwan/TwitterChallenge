
package com.challenger.ramyfradwan.twitterchallenge.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FollowersModel {

    @SerializedName("next_cursor")
    private Long mNextCursor;
    @SerializedName("next_cursor_str")
    private String mNextCursorStr;
    @SerializedName("previous_cursor")
    private Long mPreviousCursor;
    @SerializedName("previous_cursor_str")
    private String mPreviousCursorStr;
    @SerializedName("users")
    private List<UserModel> mUserModels;

    public Long getNextCursor() {
        return mNextCursor;
    }

    public String getNextCursorStr() {
        return mNextCursorStr;
    }

    public Long getPreviousCursor() {
        return mPreviousCursor;
    }

    public String getPreviousCursorStr() {
        return mPreviousCursorStr;
    }

    public List<UserModel> getUsers() {
        return mUserModels;
    }

    public static class Builder {

        private Long mNextCursor;
        private String mNextCursorStr;
        private Long mPreviousCursor;
        private String mPreviousCursorStr;
        private List<UserModel> mUserModels;

        public FollowersModel.Builder withNextCursor(Long nextCursor) {
            mNextCursor = nextCursor;
            return this;
        }

        public FollowersModel.Builder withNextCursorStr(String nextCursorStr) {
            mNextCursorStr = nextCursorStr;
            return this;
        }

        public FollowersModel.Builder withPreviousCursor(Long previousCursor) {
            mPreviousCursor = previousCursor;
            return this;
        }

        public FollowersModel.Builder withPreviousCursorStr(String previousCursorStr) {
            mPreviousCursorStr = previousCursorStr;
            return this;
        }

        public FollowersModel.Builder withUsers(List<UserModel> userModels) {
            mUserModels = userModels;
            return this;
        }

        public FollowersModel build() {
            FollowersModel FollowersModel = new FollowersModel();
            FollowersModel.mNextCursor = mNextCursor;
            FollowersModel.mNextCursorStr = mNextCursorStr;
            FollowersModel.mPreviousCursor = mPreviousCursor;
            FollowersModel.mPreviousCursorStr = mPreviousCursorStr;
            FollowersModel.mUserModels = mUserModels;
            return FollowersModel;
        }

    }

}
