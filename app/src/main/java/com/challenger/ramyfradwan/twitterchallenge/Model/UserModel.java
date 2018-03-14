
package com.challenger.ramyfradwan.twitterchallenge.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable{

    @SerializedName("contributors_enabled")
    private Boolean mContributorsEnabled;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("default_profile")
    private Boolean mDefaultProfile;
    @SerializedName("default_profile_image")
    private Boolean mDefaultProfileImage;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("favourites_count")
    private Long mFavouritesCount;
    @SerializedName("follow_request_sent")
    private Boolean mFollowRequestSent;
    @SerializedName("followers_count")
    private Long mFollowersCount;
    @SerializedName("following")
    private Boolean mFollowing;
    @SerializedName("friends_count")
    private Long mFriendsCount;
    @SerializedName("geo_enabled")
    private Boolean mGeoEnabled;
    @SerializedName("id")
    private Long mId;
    @SerializedName("id_str")
    private String mIdStr;
    @SerializedName("is_translation_enabled")
    private Boolean mIsTranslationEnabled;
    @SerializedName("is_translator")
    private Boolean mIsTranslator;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("listed_count")
    private Long mListedCount;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("muting")
    private Boolean mMuting;
    @SerializedName("name")
    private String mName;
    @SerializedName("notifications")
    private Boolean mNotifications;
    @SerializedName("profile_background_color")
    private String mProfileBackgroundColor;
    @SerializedName("profile_background_image_url")
    private String mProfileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    private String mProfileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    private Boolean mProfileBackgroundTile;
    @SerializedName("profile_image_url")
    private String mProfileImageUrl;
    @SerializedName("profile_image_url_https")
    private String mProfileImageUrlHttps;
    @SerializedName("profile_link_color")
    private String mProfileLinkColor;
    @SerializedName("profile_location")
    private Object mProfileLocation;
    @SerializedName("profile_sidebar_border_color")
    private String mProfileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    private String mProfileSidebarFillColor;
    @SerializedName("profile_text_color")
    private String mProfileTextColor;
    @SerializedName("profile_use_background_image")
    private Boolean mProfileUseBackgroundImage;
    @SerializedName("protected")
    private Boolean mProtected;
    @SerializedName("screen_name")
    private String mScreenName;
    @SerializedName("statuses_count")
    private Long mStatusesCount;
    @SerializedName("time_zone")
    private Object mTimeZone;
    @SerializedName("url")
    private Object mUrl;
    @SerializedName("utc_offset")
    private Object mUtcOffset;
    @SerializedName("verified")
    private Boolean mVerified;

    public Boolean getContributorsEnabled() {
        return mContributorsEnabled;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public Boolean getDefaultProfile() {
        return mDefaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return mDefaultProfileImage;
    }

    public String getDescription() {
        return mDescription;
    }

    public Long getFavouritesCount() {
        return mFavouritesCount;
    }

    public Boolean getFollowRequestSent() {
        return mFollowRequestSent;
    }

    public Long getFollowersCount() {
        return mFollowersCount;
    }

    public Boolean getFollowing() {
        return mFollowing;
    }

    public Long getFriendsCount() {
        return mFriendsCount;
    }

    public Boolean getGeoEnabled() {
        return mGeoEnabled;
    }

    public Long getId() {
        return mId;
    }

    public String getIdStr() {
        return mIdStr;
    }

    public Boolean getIsTranslationEnabled() {
        return mIsTranslationEnabled;
    }

    public Boolean getIsTranslator() {
        return mIsTranslator;
    }

    public String getLang() {
        return mLang;
    }

    public Long getListedCount() {
        return mListedCount;
    }

    public String getLocation() {
        return mLocation;
    }

    public Boolean getMuting() {
        return mMuting;
    }

    public String getName() {
        return mName;
    }

    public Boolean getNotifications() {
        return mNotifications;
    }

    public String getProfileBackgroundColor() {
        return mProfileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return mProfileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return mProfileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return mProfileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return mProfileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return mProfileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return mProfileLinkColor;
    }

    public Object getProfileLocation() {
        return mProfileLocation;
    }

    public String getProfileSidebarBorderColor() {
        return mProfileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return mProfileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return mProfileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return mProfileUseBackgroundImage;
    }

    public Boolean getProtected() {
        return mProtected;
    }

    public String getScreenName() {
        return mScreenName;
    }

    public Long getStatusesCount() {
        return mStatusesCount;
    }

    public Object getTimeZone() {
        return mTimeZone;
    }

    public Object getUrl() {
        return mUrl;
    }

    public Object getUtcOffset() {
        return mUtcOffset;
    }

    public Boolean getVerified() {
        return mVerified;
    }

    public static class Builder {

        private Boolean mContributorsEnabled;
        private String mCreatedAt;
        private Boolean mDefaultProfile;
        private Boolean mDefaultProfileImage;
        private String mDescription;
        private Long mFavouritesCount;
        private Boolean mFollowRequestSent;
        private Long mFollowersCount;
        private Boolean mFollowing;
        private Long mFriendsCount;
        private Boolean mGeoEnabled;
        private Long mId;
        private String mIdStr;
        private Boolean mIsTranslationEnabled;
        private Boolean mIsTranslator;
        private String mLang;
        private Long mListedCount;
        private String mLocation;
        private Boolean mMuting;
        private String mName;
        private Boolean mNotifications;
        private String mProfileBackgroundColor;
        private String mProfileBackgroundImageUrl;
        private String mProfileBackgroundImageUrlHttps;
        private Boolean mProfileBackgroundTile;
        private String mProfileImageUrl;
        private String mProfileImageUrlHttps;
        private String mProfileLinkColor;
        private Object mProfileLocation;
        private String mProfileSidebarBorderColor;
        private String mProfileSidebarFillColor;
        private String mProfileTextColor;
        private Boolean mProfileUseBackgroundImage;
        private Boolean mProtected;
        private String mScreenName;
        private Long mStatusesCount;
        private Object mTimeZone;
        private Object mUrl;
        private Object mUtcOffset;
        private Boolean mVerified;

        public UserModel.Builder withContributorsEnabled(Boolean contributorsEnabled) {
            mContributorsEnabled = contributorsEnabled;
            return this;
        }

        public UserModel.Builder withCreatedAt(String createdAt) {
            mCreatedAt = createdAt;
            return this;
        }

        public UserModel.Builder withDefaultProfile(Boolean defaultProfile) {
            mDefaultProfile = defaultProfile;
            return this;
        }

        public UserModel.Builder withDefaultProfileImage(Boolean defaultProfileImage) {
            mDefaultProfileImage = defaultProfileImage;
            return this;
        }

        public UserModel.Builder withDescription(String description) {
            mDescription = description;
            return this;
        }

        public UserModel.Builder withFavouritesCount(Long favouritesCount) {
            mFavouritesCount = favouritesCount;
            return this;
        }

        public UserModel.Builder withFollowRequestSent(Boolean followRequestSent) {
            mFollowRequestSent = followRequestSent;
            return this;
        }

        public UserModel.Builder withFollowersCount(Long followersCount) {
            mFollowersCount = followersCount;
            return this;
        }

        public UserModel.Builder withFollowing(Boolean following) {
            mFollowing = following;
            return this;
        }

        public UserModel.Builder withFriendsCount(Long friendsCount) {
            mFriendsCount = friendsCount;
            return this;
        }

        public UserModel.Builder withGeoEnabled(Boolean geoEnabled) {
            mGeoEnabled = geoEnabled;
            return this;
        }

        public UserModel.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public UserModel.Builder withIdStr(String idStr) {
            mIdStr = idStr;
            return this;
        }

        public UserModel.Builder withIsTranslationEnabled(Boolean isTranslationEnabled) {
            mIsTranslationEnabled = isTranslationEnabled;
            return this;
        }

        public UserModel.Builder withIsTranslator(Boolean isTranslator) {
            mIsTranslator = isTranslator;
            return this;
        }

        public UserModel.Builder withLang(String lang) {
            mLang = lang;
            return this;
        }

        public UserModel.Builder withListedCount(Long listedCount) {
            mListedCount = listedCount;
            return this;
        }

        public UserModel.Builder withLocation(String location) {
            mLocation = location;
            return this;
        }

        public UserModel.Builder withMuting(Boolean muting) {
            mMuting = muting;
            return this;
        }

        public UserModel.Builder withName(String name) {
            mName = name;
            return this;
        }

        public UserModel.Builder withNotifications(Boolean notifications) {
            mNotifications = notifications;
            return this;
        }

        public UserModel.Builder withProfileBackgroundColor(String profileBackgroundColor) {
            mProfileBackgroundColor = profileBackgroundColor;
            return this;
        }

        public UserModel.Builder withProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
            mProfileBackgroundImageUrl = profileBackgroundImageUrl;
            return this;
        }

        public UserModel.Builder withProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
            mProfileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
            return this;
        }

        public UserModel.Builder withProfileBackgroundTile(Boolean profileBackgroundTile) {
            mProfileBackgroundTile = profileBackgroundTile;
            return this;
        }

        public UserModel.Builder withProfileImageUrl(String profileImageUrl) {
            mProfileImageUrl = profileImageUrl;
            return this;
        }

        public UserModel.Builder withProfileImageUrlHttps(String profileImageUrlHttps) {
            mProfileImageUrlHttps = profileImageUrlHttps;
            return this;
        }

        public UserModel.Builder withProfileLinkColor(String profileLinkColor) {
            mProfileLinkColor = profileLinkColor;
            return this;
        }

        public UserModel.Builder withProfileLocation(Object profileLocation) {
            mProfileLocation = profileLocation;
            return this;
        }

        public UserModel.Builder withProfileSidebarBorderColor(String profileSidebarBorderColor) {
            mProfileSidebarBorderColor = profileSidebarBorderColor;
            return this;
        }

        public UserModel.Builder withProfileSidebarFillColor(String profileSidebarFillColor) {
            mProfileSidebarFillColor = profileSidebarFillColor;
            return this;
        }

        public UserModel.Builder withProfileTextColor(String profileTextColor) {
            mProfileTextColor = profileTextColor;
            return this;
        }

        public UserModel.Builder withProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
            mProfileUseBackgroundImage = profileUseBackgroundImage;
            return this;
        }

        public UserModel.Builder withProtected(Boolean mprotected ) {
            mProtected = mprotected;
            return this;
        }

        public UserModel.Builder withScreenName(String screenName) {
            mScreenName = screenName;
            return this;
        }

        public UserModel.Builder withStatusesCount(Long statusesCount) {
            mStatusesCount = statusesCount;
            return this;
        }

        public UserModel.Builder withTimeZone(Object timeZone) {
            mTimeZone = timeZone;
            return this;
        }

        public UserModel.Builder withUrl(Object url) {
            mUrl = url;
            return this;
        }

        public UserModel.Builder withUtcOffset(Object utcOffset) {
            mUtcOffset = utcOffset;
            return this;
        }

        public UserModel.Builder withVerified(Boolean verified) {
            mVerified = verified;
            return this;
        }

        public UserModel build() {
            UserModel UserModel = new UserModel();
            UserModel.mContributorsEnabled = mContributorsEnabled;
            UserModel.mCreatedAt = mCreatedAt;
            UserModel.mDefaultProfile = mDefaultProfile;
            UserModel.mDefaultProfileImage = mDefaultProfileImage;
            UserModel.mDescription = mDescription;
            UserModel.mFavouritesCount = mFavouritesCount;
            UserModel.mFollowRequestSent = mFollowRequestSent;
            UserModel.mFollowersCount = mFollowersCount;
            UserModel.mFollowing = mFollowing;
            UserModel.mFriendsCount = mFriendsCount;
            UserModel.mGeoEnabled = mGeoEnabled;
            UserModel.mId = mId;
            UserModel.mIdStr = mIdStr;
            UserModel.mIsTranslationEnabled = mIsTranslationEnabled;
            UserModel.mIsTranslator = mIsTranslator;
            UserModel.mLang = mLang;
            UserModel.mListedCount = mListedCount;
            UserModel.mLocation = mLocation;
            UserModel.mMuting = mMuting;
            UserModel.mName = mName;
            UserModel.mNotifications = mNotifications;
            UserModel.mProfileBackgroundColor = mProfileBackgroundColor;
            UserModel.mProfileBackgroundImageUrl = mProfileBackgroundImageUrl;
            UserModel.mProfileBackgroundImageUrlHttps = mProfileBackgroundImageUrlHttps;
            UserModel.mProfileBackgroundTile = mProfileBackgroundTile;
            UserModel.mProfileImageUrl = mProfileImageUrl;
            UserModel.mProfileImageUrlHttps = mProfileImageUrlHttps;
            UserModel.mProfileLinkColor = mProfileLinkColor;
            UserModel.mProfileLocation = mProfileLocation;
            UserModel.mProfileSidebarBorderColor = mProfileSidebarBorderColor;
            UserModel.mProfileSidebarFillColor = mProfileSidebarFillColor;
            UserModel.mProfileTextColor = mProfileTextColor;
            UserModel.mProfileUseBackgroundImage = mProfileUseBackgroundImage;
            UserModel.mProtected = mProtected;
            UserModel.mScreenName = mScreenName;
            UserModel.mStatusesCount = mStatusesCount;
            UserModel.mTimeZone = mTimeZone;
            UserModel.mUrl = mUrl;
            UserModel.mUtcOffset = mUtcOffset;
            UserModel.mVerified = mVerified;
            return UserModel;
        }

    }

}
