package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

  public EarthquakeAdapter(Activity context, ArrayList<Earthquake> list){
      super(context,0,list);
  }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_earthquake_adapter,parent,false);
        }
        Earthquake currentPlace = getItem(position);

        TextView mag=(TextView)listItemView.findViewById(R.id.text1);
        String formattedMagnitude = formatMagnitude(currentPlace.getmMagnitude());
        mag.setText(formattedMagnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable)mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentPlace.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String originallocation=currentPlace.getmPlace();
        String locationOffset;
        String primaryLocation;

        if (originallocation.contains(" of ")) {
            String[] parts = originallocation.split(" of ");
            locationOffset = parts[0] + " of ";
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originallocation;
        }

        TextView location1 =(TextView)listItemView.findViewById(R.id.text2);
        location1.setText(locationOffset);
        TextView location2 =(TextView)listItemView.findViewById(R.id.text3);
        location2.setText(primaryLocation);

        Date dateObject= new Date(currentPlace.getMdate());

        TextView dateView = (TextView)listItemView.findViewById(R.id.text4);
        String formattedDate=formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView =(TextView)listItemView.findViewById(R.id.text5);
        String formattedTime=formatTime(dateObject);
        timeView.setText(formattedTime);



  return listItemView;
  }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude) {
    int magnitudeColorid;
        int magnitudeFloor = (int) Math.floor(magnitude);
    switch(magnitudeFloor){
        case 0:
        case 1:
            magnitudeColorid= R.color.magnitude1;
           break;
        case 2:
            magnitudeColorid=R.color.magnitude2;
            break;
        case 3:
            magnitudeColorid=R.color.magnitude3;
            break;
        case 4:
            magnitudeColorid=R.color.magnitude4;
            break;
        case 5:
            magnitudeColorid= R.color.magnitude5;
            break;
        case 6:
            magnitudeColorid= R.color.magnitude6;
            break;
        case 7:
            magnitudeColorid= R.color.magnitude7;
            break;
        case 8:
            magnitudeColorid= R.color.magnitude8;
            break;
        case 9:
            magnitudeColorid= R.color.magnitude9;
            break;
        default:
            magnitudeColorid= R.color.magnitude10plus;
            break;
    }
        return ContextCompat.getColor(getContext(), magnitudeColorid);
    }
}
