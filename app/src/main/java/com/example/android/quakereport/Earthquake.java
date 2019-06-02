package com.example.android.quakereport;

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private long mgetTimeinmilisecs;

    public Earthquake(String magnitude, String place, long timeinmilisecs){
        this.mMagnitude=magnitude;
        this.mPlace=place;
        this.mgetTimeinmilisecs=timeinmilisecs;
    }

    public String getmMagnitude() { return mMagnitude;
    }
    public String getmPlace(){
        return mPlace;
    }
    public long getMdate(){
        return mgetTimeinmilisecs;
    }
}
