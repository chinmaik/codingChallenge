package com.giant.bomb.code.challenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageDataBean implements Parcelable {

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("medium_url")
    @Expose
    private String mediumUrl;
    @SerializedName("screen_url")
    @Expose
    private String screenUrl;
    @SerializedName("screen_large_url")
    @Expose
    private String screenLargeUrl;
    @SerializedName("small_url")
    @Expose
    private String smallUrl;
    @SerializedName("super_url")
    @Expose
    private String superUrl;
    @SerializedName("thumb_url")
    @Expose
    private String thumbUrl;
    @SerializedName("tiny_url")
    @Expose
    private String tinyUrl;
    @SerializedName("original_url")
    @Expose
    private String originalUrl;
    @SerializedName("image_tags")
    @Expose
    private String imageTags;

    protected ImageDataBean(Parcel in) {
        iconUrl = in.readString();
        mediumUrl = in.readString();
        screenUrl = in.readString();
        screenLargeUrl = in.readString();
        smallUrl = in.readString();
        superUrl = in.readString();
        thumbUrl = in.readString();
        tinyUrl = in.readString();
        originalUrl = in.readString();
        imageTags = in.readString();
    }

    public static final Creator<ImageDataBean> CREATOR = new Creator<ImageDataBean>() {
        @Override
        public ImageDataBean createFromParcel(Parcel in) {
            return new ImageDataBean(in);
        }

        @Override
        public ImageDataBean[] newArray(int size) {
            return new ImageDataBean[size];
        }
    };

    public String getThumbUrl() {
        return thumbUrl;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.iconUrl);
        dest.writeString(this.mediumUrl);
        dest.writeString(this.screenUrl);
        dest.writeString(this.screenLargeUrl);
        dest.writeString(this.smallUrl);
        dest.writeString(this.superUrl);
        dest.writeString(this.thumbUrl);
        dest.writeString(this.tinyUrl);
        dest.writeString(this.originalUrl);
        dest.writeString(this.imageTags);
    }
}