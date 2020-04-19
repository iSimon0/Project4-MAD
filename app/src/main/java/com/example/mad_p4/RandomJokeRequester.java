package com.example.mad_p4;

import android.app.Activity;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class RandomJokeRequester extends JokeRequester {
    public RandomJokeRequester(Activity activity) {
        super(activity);
    }

    public void requestRandomDadJoke() throws JSONException {
        getWebsite().prepareRequest();
    }
}
