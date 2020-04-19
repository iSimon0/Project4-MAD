package com.example.mad_p4;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class DadJokeListener implements Response.Listener<JSONObject> {
    Activity activity;
    JSONObject response;

    public DadJokeListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(JSONObject response) {
        this.response = response;
        try {
            Log.i("Joke", getJoke(response));

            // NOTE: GET THE JOKE AND EDIT TEXT VIEWS HERE

        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String getJoke(JSONObject response) throws JSONException {
        return response.get("joke").toString();
    }
}
