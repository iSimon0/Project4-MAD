package com.example.mad_p4;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class RandomJokeListener implements Response.Listener<JSONObject> {
    Activity activity;
    JSONObject response;

    public RandomJokeListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(JSONObject response) {
        this.response = response;
        TextView text;
        try {
            Log.i("Random Joke", getJoke(response));

            text = activity.findViewById(R.id.randomJokeText);
            text.setText(getJoke(response));

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
