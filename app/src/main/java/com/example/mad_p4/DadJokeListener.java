package com.example.mad_p4;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

public class DadJokeListener implements RequestQueue.RequestFinishedListener {
    Context context;

    public DadJokeListener(Context context) {
        this.context = context;
    }

    @Override
    public void onRequestFinished(Request request) {

    }
}
