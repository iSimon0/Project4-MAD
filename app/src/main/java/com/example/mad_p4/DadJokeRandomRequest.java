package com.example.mad_p4;

import androidx.annotation.Nullable;

import com.android.volley.Response;

import org.json.JSONObject;

public class DadJokeRandomRequest extends DadJokeRequest {
    public DadJokeRandomRequest(Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(listener, errorListener, "");
    }
}
