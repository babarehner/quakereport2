package com.example.android.quakereport;

/**
 * Created by mike on 4/3/17.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude the size of the eathquake
     * @param location city location of the earthquake
     * @param timeInMilliseconds the time in millisconds when the earthquake occurred
     * @param url web page of earthquake
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mLocation = location;
        mMagnitude = magnitude;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getTimeInMilliseconds() {return mTimeInMilliseconds;}

    public String getUrl() {return mUrl; }

}
