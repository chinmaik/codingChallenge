package com.giant.bomb.code.challenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameBean implements Parcelable {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private ImageDataBean imageDataBean;

    protected GameBean(Parcel in) {
        description = in.readString();
        name = in.readString();
        imageDataBean = in.readParcelable(ImageDataBean.class.getClassLoader());
    }

    public static final Creator<GameBean> CREATOR = new Creator<GameBean>() {
        @Override
        public GameBean createFromParcel(Parcel in) {
            return new GameBean(in);
        }

        @Override
        public GameBean[] newArray(int size) {
            return new GameBean[size];
        }
    };

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ImageDataBean getImageDataBean() {
        return imageDataBean;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeString(this.name);
        dest.writeParcelable(this.imageDataBean, flags);
    }


}
