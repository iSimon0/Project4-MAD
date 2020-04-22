package com.example.mad_p4;

import android.app.Activity;

import org.json.JSONException;

public class RandomJokeRequester extends JokeRequester {
    public RandomJokeRequester(Activity activity) {
        super(activity);
    }

    public void requestRandomDadJoke() throws JSONException {
        getWebsite().sendRequest();
    }
}
