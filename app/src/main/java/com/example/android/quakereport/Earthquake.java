package com.example.android.quakereport;

public class Earthquake {
    private Double mMagnitude;
    private String mPlace;
    private long mgetTimeinmilisecs;

    public Earthquake(Double magnitude, String place, long timeinmilisecs){
        this.mMagnitude=magnitude;
        this.mPlace=place;
        this.mgetTimeinmilisecs=timeinmilisecs;
    }

    public Double getmMagnitude() { return mMagnitude;
    }
    public String getmPlace(){
        return mPlace;
    }
    public long getMdate(){
        return mgetTimeinmilisecs;
    }
}
