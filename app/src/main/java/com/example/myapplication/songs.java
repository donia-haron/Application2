package com.example.myapplication;

import android.media.MediaPlayer;

public class songs {

    private String msongName;
    private String martistName;
    private int mImageResourceId;

    public songs(String vartist ,String vName, int imageResourceId) {
        msongName = vName;
        martistName =vartist ;
        mImageResourceId = imageResourceId;
    }
    public String getsongName() {
        return msongName;
    }

    public String getartistName() {
        return martistName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}



