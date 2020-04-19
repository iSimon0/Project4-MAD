package com.example.mad_p4;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchJokeListener implements Response.Listener<JSONObject> {
    Activity activity;

    public SearchJokeListener(Activity activity) {
        this.activity = activity;

    }

    @Override
    public void onResponse(JSONObject response) {
        String[] jokes;

        try {
            jokes = getJokes(response);

            for (String joke : jokes) {
                Log.i("Search Joke", joke);
            }


            // update recycler view here
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String[] getJokes(JSONObject response) throws JSONException {
        int limit = response.getInt("limit");
        ArrayList<String> jokes = new ArrayList<>();
        JSONArray results = response.getJSONArray("results");

        for (int i = 0; i < limit; i++) {
            jokes.add(results.getJSONObject(i).getString("joke"));
        }

        return (String[]) jokes.toArray();
    }

}
