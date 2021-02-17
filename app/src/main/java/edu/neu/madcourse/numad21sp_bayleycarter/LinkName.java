package edu.neu.madcourse.numad21sp_bayleycarter;

import android.content.ClipData;
import android.os.Parcel;
import android.os.Parcelable;

public class LinkName implements ItemClickListener {

    private String linkName;
    private String linkUrl;


    public LinkName(String linkName, String linkUrl) {
        this.linkName = linkName;
        this.linkUrl = linkUrl;

    }


    public String getLinkName() {
        return "Name: " + this.linkName;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }


    @Override
    public void onItemClick(int position) {
        //launch url
    }
}
