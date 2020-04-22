package com.example.mad_p4.listener;

import android.content.Context;

import com.android.volley.Response;
import com.example.mad_p4.adapter.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DadJokeSearchListener implements Response.Listener<JSONObject> {
//    Activity activity;
    RecyclerViewAdapter adapter;
    ArrayList<String> jokes;
    Context context;

//    public DadJokeSearchListener(Activity activity) {
//        this.activity = activity;
//    }

    public void setListAdapter(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onResponse(JSONObject response) {

//        try {
//            jokes = getJokes(response);
//            for (String joke : jokes) {
//                Log.i("Search Joke", joke);
//            }
//            RecyclerView recyclerView = activity.findViewById(R.id.jokeList);
//            recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            adapter = new RecyclerViewAdapter(context, jokes);
//            recyclerView.setAdapter(adapter);
//        }
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
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
