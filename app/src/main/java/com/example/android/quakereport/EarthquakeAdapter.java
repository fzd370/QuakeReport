package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        mag.setText(currentPlace.getmMagnitude());

        TextView location =(TextView)listItemView.findViewById(R.id.text2);
        location.setText(currentPlace.getmPlace());

        Date dateObject= new Date(currentPlace.getMdate());

        TextView dateView = (TextView)listItemView.findViewById(R.id.text3);
        String formattedDate=formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView =(TextView)listItemView.findViewById(R.id.text4);
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
}
