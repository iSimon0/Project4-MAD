package com.example.mad_p4;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

public class DadJokeListener implements RequestQueue.RequestFinishedListener {
    Activity activity;

    public DadJokeListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onRequestFinished(Request request) {

    }


}
