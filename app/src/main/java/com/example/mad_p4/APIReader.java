package com.example.mad_p4;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class APIReader {

    private String api_url;
    private RequestQueue requestQueue;
    private JSONObject response;

    public APIReader(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public APIReader(Context context, String url, String... args) {
        this(context);
        setURL(url, args);
    }

    public void setURL(String url, String... args) {
        api_url = String.format(url, args);
    }


//    public APIReader(Context context, String city) {
//
//        // instantiate the request queue
//        requestQueue = Volley.newRequestQueue(context); // used to fulfill requests
//        this.city = city;
//
//    }

    public void prepareRequest() {

        // create object request
        JsonObjectRequest jsonObjectRequest = // defines the kind of request we want to do and how to handle it
                new JsonObjectRequest(
                        Request.Method.GET, // the request method
                        api_url, // the URL
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) { // I guess I'm supposed to capture the request here somehow

                                try {
                                    APIReader.this.response = response.getJSONObject("main");
                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.e("Volley Error", error.toString());

                            }
                        }
                );

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
