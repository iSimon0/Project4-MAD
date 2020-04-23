package com.example.mad_p4.requester.request.listener;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_p4.recycler.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchDadJokeResponseListener extends DadJokeResponseListener <RecyclerView> {

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> jokes;

        try {
            jokes = getJokes(response);

            getTarget().setAdapter(
                    new RecyclerViewAdapter(jokes)
            );
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
