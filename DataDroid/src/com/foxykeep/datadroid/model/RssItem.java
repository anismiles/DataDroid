package com.foxykeep.datadroid.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.foxykeep.datadroid.factory.RssFactory;

/**
 * Class defining an RSS item
 * <p>
 * Fields are based on this definition : http://www.w3schools.com/rss/rss_item.asp
 * </p>
 * <p>
 * If you need to add more fields, subclass this class and add your fields. (Don't forget to call the corresponding <code>super</code> method in both
 * constructors) <br/>
 * You'll also need to modify the method {@link RssFeed#readRssItemList(Parcel)} as well as the {@link RssFactory}
 * 
 * @author Foxykeep
 */
public class RssItem implements Parcelable {

    // Required
    public String title;
    public String link;
    public String description;

    // Optional
    public String commentsLink = null;
    public long pubDate = -1;
    public String author = null;

    public String enclosureLink = null;
    public int enclosureSize = -1;
    public String enclosureMimeType = null;

    public String guid = null;
    public boolean isGuidPermaLink = false;

    public ArrayList<String> categoryList = new ArrayList<String>();

    public String encodedContext = null;

    public String sourceLink;
    public String sourceText;

    public RssItem() {

    }

    // Parcelable management
    private RssItem(final Parcel in) {
        title = in.readString();
        link = in.readString();
        description = in.readString();

        commentsLink = in.readString();
        pubDate = in.readLong();
        author = in.readString();

        enclosureLink = in.readString();
        enclosureSize = in.readInt();
        enclosureMimeType = in.readString();

        guid = in.readString();
        isGuidPermaLink = in.readInt() == 1;

        in.readStringList(categoryList);

        encodedContext = in.readString();

        sourceLink = in.readString();
        sourceText = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(description);

        dest.writeString(commentsLink);
        dest.writeLong(pubDate);
        dest.writeString(author);

        dest.writeString(enclosureLink);
        dest.writeInt(enclosureSize);
        dest.writeString(enclosureMimeType);

        dest.writeString(guid);
        dest.writeInt(isGuidPermaLink ? 1 : 0);

        dest.writeStringList(categoryList);

        dest.writeString(encodedContext);

        dest.writeString(sourceLink);
        dest.writeString(sourceText);
    }

    public static final Parcelable.Creator<RssItem> CREATOR = new Parcelable.Creator<RssItem>() {
        public RssItem createFromParcel(final Parcel in) {
            return new RssItem(in);
        }

        public RssItem[] newArray(final int size) {
            return new RssItem[size];
        }
    };
}
