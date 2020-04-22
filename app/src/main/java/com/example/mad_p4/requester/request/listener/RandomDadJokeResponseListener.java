package com.example.mad_p4.requester.request.listener;

import android.util.Log;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class RandomDadJokeResponseListener implements Response.Listener<JSONObject> {
    JSONObject response;

    @Override
    public void onResponse(JSONObject response) {
        this.response = response;

        try {
            Log.i("Random Joke", getJoke(response));
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getJoke(JSONObject response) throws JSONException {
        return response.get("joke").toString();
    }
}
