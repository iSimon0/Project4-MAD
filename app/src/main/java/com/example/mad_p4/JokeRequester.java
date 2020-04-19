package com.example.mad_p4;

import android.app.Activity;

import com.android.volley.Response;

import org.json.JSONObject;

public abstract class JokeRequester {
    private APIReader website;
    public static String url = "https://icanhazdadjoke.com/";

    public JokeRequester(Activity activity) {
        website = new APIReader(activity, url);
    }

    public APIReader getWebsite() { return website; }

    public void setJokeListener(Response.Listener <JSONObject> listener) {
        website.setResponseListener(listener);
    }
}
