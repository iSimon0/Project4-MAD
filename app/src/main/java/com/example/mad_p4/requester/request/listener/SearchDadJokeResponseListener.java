package com.example.mad_p4.requester.request.listener;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_p4.activity.SearchResults;
import com.example.mad_p4.recycler.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchDadJokeResponseListener extends DadJokeResponseListener <RecyclerView> {
    Activity activity;

    public SearchDadJokeResponseListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> jokes;

        try {
            jokes = getJokes(response);

            Intent info = new Intent(activity, SearchResults.class);
            info.putExtra("data", jokes);
            activity.startActivity(info);

//            getTarget().setAdapter(
//                    new RecyclerViewAdapter(jokes)
//            );
        }
        catch (JSONException e) {

        }
    }

    private ArrayList<String> getJokes(JSONObject response) throws JSONException {
        ArrayList<String> jokes = new ArrayList<>();
        JSONArray results = response.getJSONArray("results");


        for (int i = 0; i < results.length(); i++) {
            jokes.add(results.getJSONObject(i).getString("joke"));
        }

        return jokes;
    }

}
