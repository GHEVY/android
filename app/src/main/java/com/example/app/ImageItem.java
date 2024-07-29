package com.example.app;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ImageItem implements Parcelable {
    int  image;
    String text;
    boolean isFav;
    String continent;

    public ImageItem(int image, String text,String continent) {
        this.image = image;
        this.text = text;
        this.continent = continent;
    }

    public  String getContinent() {
        return continent;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    protected ImageItem(Parcel in) {
        image = in.readInt();
        text = in.readString();
        isFav = in.readByte() != 0;
    }

    public static final Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel in) {
            return new ImageItem(in);
        }

        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(text);
        dest.writeByte((byte) (isFav ? 1 : 0));
    }

}
