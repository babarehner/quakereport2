package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.magnitude;

/**
 * Created by mike on 4/3/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private final static String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }



        Earthquake currentEarthQuake = getItem(position);


        String formattedMagnitude = formatMagnitude(currentEarthQuake.getMagnitude());
        TextView magnitudeView = (TextView) listItemView.findViewById(magnitude);
        magnitudeView.setText(formattedMagnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        String originalLocation = currentEarthQuake.getLocation();
        String location_offset;
        String primary_location;
        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            location_offset = parts[0] + LOCATION_SEPARATOR;
            primary_location = parts[1];
        } else {
            location_offset = getContext().getString(R.string.near_the);
            primary_location = originalLocation;
        }

        TextView offsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        offsetView.setText(location_offset);

        TextView primaryView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryView.setText(primary_location);

        Date dateObject = new Date(currentEarthQuake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string- "mar 3, 2014" from a Date object.
     */
    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL, dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted time string- "4:15 AM" from a Date object.
     */
    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h::mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place- "6.7"
     * from a double decimal value
     */
    private String formatMagnitude(double magnitude){
        return (new DecimalFormat("0.0")).format(magnitude);
    }

    /**
     * Returns the correct color value based on the  current earthquakes magnitude value
     */
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        // ContextCompat.getColor converts the colorResouce ID into an actual integer color value
        // How does this work??
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
