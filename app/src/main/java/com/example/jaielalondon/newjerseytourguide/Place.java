package com.example.jaielalondon.newjerseytourguide;

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
        mCity = city;
        mPlaceImageResourceId = imageResourceId;

    }

    /**
     * Create new {@link Place} Object
     * @param placeName is the name of the place
     * @param shortDescription is a short description of the place (i.e "Theme Park")
     * @param city is the city where the place is
     * @param imageResourceId is the resource Id for the image associated with the place
     * @param longDescription is a longer description of the {@Place}
     */
    public Place(String placeName, String shortDescription, String city,
                 int imageResourceId, String longDescription) {
        mName = placeName;
        mShortDescription = shortDescription;
        mCity = city;
        mPlaceImageResourceId = imageResourceId;
        mLongDescription = longDescription;

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
}
