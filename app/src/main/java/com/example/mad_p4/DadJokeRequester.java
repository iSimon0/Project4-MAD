package com.example.mad_p4;

import android.app.Activity;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class DadJokeRequester {
    private APIReader reader;
    public static String url = "https://icanhazdadjoke.com/";

    public DadJokeRequester(Activity context) {
        reader = new APIReader(context, url);
        reader.setResponseListener(new DadJokeListener(context));
    }

    public void requestRandomDadJoke() throws JSONException {
        reader.prepareRequest();
    }

    public String getJoke() throws JSONException {
        return reader.getAttribute("joke").toString();
    }

    public String getJoke(JSONObject object) throws JSONException {
        return object.get("joke").toString();
    }
}
