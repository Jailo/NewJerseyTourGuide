package com.example.jaielalondon.newjerseytourguide;

import android.util.Log;

/**
 * Created by jaielalondon on 6/2/18.
 */

public class Place {

    /* Place Name */
    private String mName;

    /* Short Description for place */
    private String mShortDescription;

    /* Long Description for place */
    private String mLongDescription;


    /* Place city*/
    private String mCity;

    /* Place Image resource ID */
    private int mPlaceImageResourceId;

    /* Place's address */
    private String mAddress;


    /* Place's Website Url */
    private String mWebsiteUrl;

    /**
     * Create new {@link Place} Object
     * @param placeName is the name of the place
     * @param shortDescription is a short description of the place (i.e "Theme Park")
     * @param city is the city where the place is
     * @param imageResourceId is the resource Id for the image associated with the place
     */
    public Place(String placeName, String shortDescription, String city,
                 int imageResourceId) {
        mName = placeName;
        mShortDescription = shortDescription;
        mCity = city + ", NJ";
        mPlaceImageResourceId = imageResourceId;

    }

    /**
     * Create new {@link Place} Object
     * @param placeName is the name of the {@Place}
     * @param shortDescription is a short description of the {@Place} (i.e "Theme Park")
     * @param city is the city where the {@Place} is
     * @param imageResourceId is the resource Id for the image associated with the {@Place}
     * @param longDescription is a longer description of the {@Place}
     * @param address is the {@Place}'s address
     * @param websiteUrl is the{@Place}'s website
     */
    public Place(String placeName, String shortDescription, String city,
                 int imageResourceId, String longDescription, String address, String websiteUrl) {
        mName = placeName;
        mShortDescription = shortDescription;
        mCity = "In " + city + ", NJ";
        mPlaceImageResourceId = imageResourceId;
        mLongDescription = longDescription;
        mAddress = address;

        // Check if the website url does NOT start with http:// or https://
        if (!websiteUrl.startsWith("http://") && !websiteUrl.startsWith("https://")){
            // Assign http:// and the website url to mWebsiteUrl (i.e http://www.example.com)
            mWebsiteUrl = "http://" + websiteUrl;
        } else{
            // If websiteUrl DOES begin with http:// or https://
            //then assign websiteUrl value to mWebsiteUrl
            mWebsiteUrl = websiteUrl;
        }

    }

    /**
     *
     * @return the name of the Place
     */
    public String getPlaceName() {
        return mName;
    }


    /**
     *
     * @return Short Description of place
     */
    public String getPlaceShortDescription() {
        return mShortDescription;
    }

    /**
     *
     * @return the places city
     */
    public String getCity() {
        return mCity;
    }


    /**
     *
     * @return Image resource ID for place
     */
    public int getPlaceImageResourceId() {
        return mPlaceImageResourceId;
    }


    /**
     *
     * @return Long Description of place
     */
    public String getLongDescription() { return mLongDescription; }


    /**
     *
     * @return Place's address
     */
    public String getAddress() { return mAddress;  }


    /**
     *
     * @return Website URL of place
     */
    public String getWebsiteUrl() { return mWebsiteUrl; }


}
