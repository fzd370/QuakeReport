package com.example.android.quakereport;

public class Earthquake {
    private Double mMagnitude;
    private String mPlace;
    private long mgetTimeinmilisecs;
    private String murl;

    public Earthquake(Double magnitude, String place, long timeinmilisecs, String url){
        this.mMagnitude=magnitude;
        this.mPlace=place;
        this.mgetTimeinmilisecs=timeinmilisecs;
        this.murl=url;
    }


    public Double getmMagnitude() {

        return mMagnitude;
    }
    public String getmPlace(){

        return mPlace;
    }
    public long getMdate(){

        return mgetTimeinmilisecs;
    }

    public String getMurl() {

        return murl;
    }
}
