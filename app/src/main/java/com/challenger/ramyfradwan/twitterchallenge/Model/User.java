
package com.challenger.ramyfradwan.twitterchallenge.Model;

import com.google.gson.annotations.SerializedName;

public class User {

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

        public User.Builder withContributorsEnabled(Boolean contributorsEnabled) {
            mContributorsEnabled = contributorsEnabled;
            return this;
        }

        public User.Builder withCreatedAt(String createdAt) {
            mCreatedAt = createdAt;
            return this;
        }

        public User.Builder withDefaultProfile(Boolean defaultProfile) {
            mDefaultProfile = defaultProfile;
            return this;
        }

        public User.Builder withDefaultProfileImage(Boolean defaultProfileImage) {
            mDefaultProfileImage = defaultProfileImage;
            return this;
        }

        public User.Builder withDescription(String description) {
            mDescription = description;
            return this;
        }

        public User.Builder withFavouritesCount(Long favouritesCount) {
            mFavouritesCount = favouritesCount;
            return this;
        }

        public User.Builder withFollowRequestSent(Boolean followRequestSent) {
            mFollowRequestSent = followRequestSent;
            return this;
        }

        public User.Builder withFollowersCount(Long followersCount) {
            mFollowersCount = followersCount;
            return this;
        }

        public User.Builder withFollowing(Boolean following) {
            mFollowing = following;
            return this;
        }

        public User.Builder withFriendsCount(Long friendsCount) {
            mFriendsCount = friendsCount;
            return this;
        }

        public User.Builder withGeoEnabled(Boolean geoEnabled) {
            mGeoEnabled = geoEnabled;
            return this;
        }

        public User.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public User.Builder withIdStr(String idStr) {
            mIdStr = idStr;
            return this;
        }

        public User.Builder withIsTranslationEnabled(Boolean isTranslationEnabled) {
            mIsTranslationEnabled = isTranslationEnabled;
            return this;
        }

        public User.Builder withIsTranslator(Boolean isTranslator) {
            mIsTranslator = isTranslator;
            return this;
        }

        public User.Builder withLang(String lang) {
            mLang = lang;
            return this;
        }

        public User.Builder withListedCount(Long listedCount) {
            mListedCount = listedCount;
            return this;
        }

        public User.Builder withLocation(String location) {
            mLocation = location;
            return this;
        }

        public User.Builder withMuting(Boolean muting) {
            mMuting = muting;
            return this;
        }

        public User.Builder withName(String name) {
            mName = name;
            return this;
        }

        public User.Builder withNotifications(Boolean notifications) {
            mNotifications = notifications;
            return this;
        }

        public User.Builder withProfileBackgroundColor(String profileBackgroundColor) {
            mProfileBackgroundColor = profileBackgroundColor;
            return this;
        }

        public User.Builder withProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
            mProfileBackgroundImageUrl = profileBackgroundImageUrl;
            return this;
        }

        public User.Builder withProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
            mProfileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
            return this;
        }

        public User.Builder withProfileBackgroundTile(Boolean profileBackgroundTile) {
            mProfileBackgroundTile = profileBackgroundTile;
            return this;
        }

        public User.Builder withProfileImageUrl(String profileImageUrl) {
            mProfileImageUrl = profileImageUrl;
            return this;
        }

        public User.Builder withProfileImageUrlHttps(String profileImageUrlHttps) {
            mProfileImageUrlHttps = profileImageUrlHttps;
            return this;
        }

        public User.Builder withProfileLinkColor(String profileLinkColor) {
            mProfileLinkColor = profileLinkColor;
            return this;
        }

        public User.Builder withProfileLocation(Object profileLocation) {
            mProfileLocation = profileLocation;
            return this;
        }

        public User.Builder withProfileSidebarBorderColor(String profileSidebarBorderColor) {
            mProfileSidebarBorderColor = profileSidebarBorderColor;
            return this;
        }

        public User.Builder withProfileSidebarFillColor(String profileSidebarFillColor) {
            mProfileSidebarFillColor = profileSidebarFillColor;
            return this;
        }

        public User.Builder withProfileTextColor(String profileTextColor) {
            mProfileTextColor = profileTextColor;
            return this;
        }

        public User.Builder withProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
            mProfileUseBackgroundImage = profileUseBackgroundImage;
            return this;
        }

        public User.Builder withProtected(Boolean mprotected ) {
            mProtected = mprotected;
            return this;
        }

        public User.Builder withScreenName(String screenName) {
            mScreenName = screenName;
            return this;
        }

        public User.Builder withStatusesCount(Long statusesCount) {
            mStatusesCount = statusesCount;
            return this;
        }

        public User.Builder withTimeZone(Object timeZone) {
            mTimeZone = timeZone;
            return this;
        }

        public User.Builder withUrl(Object url) {
            mUrl = url;
            return this;
        }

        public User.Builder withUtcOffset(Object utcOffset) {
            mUtcOffset = utcOffset;
            return this;
        }

        public User.Builder withVerified(Boolean verified) {
            mVerified = verified;
            return this;
        }

        public User build() {
            User User = new User();
            User.mContributorsEnabled = mContributorsEnabled;
            User.mCreatedAt = mCreatedAt;
            User.mDefaultProfile = mDefaultProfile;
            User.mDefaultProfileImage = mDefaultProfileImage;
            User.mDescription = mDescription;
            User.mFavouritesCount = mFavouritesCount;
            User.mFollowRequestSent = mFollowRequestSent;
            User.mFollowersCount = mFollowersCount;
            User.mFollowing = mFollowing;
            User.mFriendsCount = mFriendsCount;
            User.mGeoEnabled = mGeoEnabled;
            User.mId = mId;
            User.mIdStr = mIdStr;
            User.mIsTranslationEnabled = mIsTranslationEnabled;
            User.mIsTranslator = mIsTranslator;
            User.mLang = mLang;
            User.mListedCount = mListedCount;
            User.mLocation = mLocation;
            User.mMuting = mMuting;
            User.mName = mName;
            User.mNotifications = mNotifications;
            User.mProfileBackgroundColor = mProfileBackgroundColor;
            User.mProfileBackgroundImageUrl = mProfileBackgroundImageUrl;
            User.mProfileBackgroundImageUrlHttps = mProfileBackgroundImageUrlHttps;
            User.mProfileBackgroundTile = mProfileBackgroundTile;
            User.mProfileImageUrl = mProfileImageUrl;
            User.mProfileImageUrlHttps = mProfileImageUrlHttps;
            User.mProfileLinkColor = mProfileLinkColor;
            User.mProfileLocation = mProfileLocation;
            User.mProfileSidebarBorderColor = mProfileSidebarBorderColor;
            User.mProfileSidebarFillColor = mProfileSidebarFillColor;
            User.mProfileTextColor = mProfileTextColor;
            User.mProfileUseBackgroundImage = mProfileUseBackgroundImage;
            User.mProtected = mProtected;
            User.mScreenName = mScreenName;
            User.mStatusesCount = mStatusesCount;
            User.mTimeZone = mTimeZone;
            User.mUrl = mUrl;
            User.mUtcOffset = mUtcOffset;
            User.mVerified = mVerified;
            return User;
        }

    }

}
