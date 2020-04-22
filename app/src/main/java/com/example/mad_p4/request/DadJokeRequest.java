package com.example.mad_p4.request;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class DadJokeRequest extends JsonObjectRequest {
    public static final String URL = "https://icanhazdadjoke.com/";
    private Response.Listener listener;
    private Response.ErrorListener errorListener;

    public DadJokeRequest(Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener, String extra) {
        super(Method.GET, URL + extra, null, listener, errorListener);
        this.listener = listener;
    }

    @Override // required to access the API and get response data
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();

        headers.put("User-Agent", "Dad Joke Mobile App => https://github.com/iSimon0/Project4-MAD; Contact => myersmk@umich.edu, isimon@umich.edu");
        headers.put("Accept", "application/json");
        return headers;
    }

    public Response.Listener getListener() { return listener; }
}
