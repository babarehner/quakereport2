package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by mike on 4/18/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}
     * @param context of the actiivity
     * @param url to load date from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        Log.v(LOG_TAG, "Constructor, initLoader()");
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG, "onStartLoading method");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.v(LOG_TAG, "loadInBackground method");
        // Don't perform the request if there are no URLs, or the first URL is null.
        // What happened to <if (mUrl.length == 0 || ) ????
        if ( mUrl == null){
            return null;
        }

        // List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return QueryUtils.fetchEarthquakeData(mUrl);
    }

}
