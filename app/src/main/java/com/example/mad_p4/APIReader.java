package com.example.mad_p4;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class APIReader {

    private String baseURL;
    private String formattedURL;
    private RequestQueue requestQueue;
    private JSONObject response;
    private Response.Listener listener;

    public APIReader(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public APIReader(Context context, String url, Object... args) {
        this(context);
        baseURL = url;

        formatURL(url, args);
    }

    public String getFormattedURL() { return formattedURL; }
    public void formatURL(Object... format_args) {
        formattedURL = String.format(baseURL, format_args);
    }

    public String getBaseURL() { return baseURL; }
    public void setBaseURL(String url, Object... format_args) {
        baseURL = url;
        formatURL(format_args);
    }

    public void setResponseListener(Response.Listener listener) {
        this.listener = listener;
    }

    public void prepareRequest() {

        // create object request
        JsonObjectRequest jsonObjectRequest = // defines the kind of request we want to do and how to handle it
                new JsonObjectRequest(
                        Request.Method.GET, // the request method
                        formattedURL, // the URL
                        null,
                        listener,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.e("Volley Error", error.toString());

                            }


                        }
                )
                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<>();

                        headers.put("User-Agent", "Dad Joke Mobile App => https://github.com/iSimon0/Project4-MAD; Contact => myersmk@umich.edu, isimon@umich.edu");
                        headers.put("Accept", "application/json");
                        return headers;
                    }
                };

        // add request to the queue
        requestQueue.add(jsonObjectRequest); // actually processes the request for json data

    }

    public void addOnRequestFinishedListener(RequestQueue.RequestFinishedListener listener) {
        requestQueue.addRequestFinishedListener(listener);
    }

    public Object getAttribute(String name) throws JSONException {
        return response.get(name);
    }


}
