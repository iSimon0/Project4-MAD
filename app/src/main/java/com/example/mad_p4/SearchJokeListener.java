package com.example.mad_p4;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchJokeListener implements Response.Listener<JSONObject> {
    Activity activity;
    RecyclerViewAdapter adapter;
    ArrayList<String> jokes;
    Context context;

    public SearchJokeListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            jokes = getJokes(response);
            for (String joke : jokes) {
                Log.i("Search Joke", joke);
            }
            RecyclerView recyclerView = activity.findViewById(R.id.jokeList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter = new RecyclerViewAdapter(context, jokes);
            recyclerView.setAdapter(adapter);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> getJokes(JSONObject response) throws JSONException {
        int limit = response.getInt("limit");
        ArrayList<String> jokes = new ArrayList<>();
        JSONArray results = response.getJSONArray("results");

        for (int i = 0; i < limit; i++) {
            jokes.add(results.getJSONObject(i).getString("joke"));
        }

        return jokes;
    }

}
