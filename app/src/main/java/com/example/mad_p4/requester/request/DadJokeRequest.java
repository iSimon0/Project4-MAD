/**
 * AUTHOR: MITCHELL MYERS
 * DATE: 4/23/2020
 */

package com.example.mad_p4.requester.request;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mad_p4.requester.request.listener.DadJokeResponseListener;
import com.example.mad_p4.requester.request.listener.RandomDadJokeResponseListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class DadJokeRequest extends JsonObjectRequest {
    private static final String URL = "https://icanhazdadjoke.com/";
    private static final String message = "Dad Joke App for Mobile App Design";
    private static final String repo = "https://github.com/iSimon0/Project4-MAD";
    private static final String contacts = "myersmk@umich.edu, isimon@umich.edu";


    public DadJokeRequest(Response.Listener listener, @Nullable Response.ErrorListener errorListener, String extra) {
        super(Method.GET, URL + extra, null, listener, errorListener);
    }

    @Override // required to access the API and get response data
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();

        // tells the API who is accessing the website
        headers.put(
                "User-Agent",
                message + " => " + repo + "; Contact => " + contacts
        );

        // tells the API to send back a JSON object in response
        headers.put("Accept", "application/json");
        return headers;
    }
}
