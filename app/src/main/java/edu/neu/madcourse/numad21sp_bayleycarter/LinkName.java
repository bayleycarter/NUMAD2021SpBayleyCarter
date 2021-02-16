package edu.neu.madcourse.numad21sp_bayleycarter;

import android.os.Parcel;
import android.os.Parcelable;

public class LinkName implements ItemClickListener {

    private final String linkName;
    private final String linkUrl;


    public LinkName(String linkName, String linkUrl) {
        this.linkName = linkName;
        this.linkUrl = linkUrl;

    }


    public String getLinkName() {
        return "Name: " + this.linkName;
    }

    public String getLinkUrl() {
        return "URL: " + this.linkUrl;
    }


    @Override
    public void onItemClick(int position) {
        //launch url
    }


}
