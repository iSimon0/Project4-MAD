package com.example.mad_p4;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public class DadJokeSearchRequest extends DadJokeRequest {

    public DadJokeSearchRequest(String term, int pageNumber, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(listener, errorListener, "search?term=" + term + "?page=" + pageNumber);
    }

}
