package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by mike on 4/18/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {


    public EarthquakeLoader(Context context, String url) {
        super(context);
        // TODO: Finish implementing this constructor
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        // TODO: Implement this method
        // null from ctrl insert
        return null;
    }


}
