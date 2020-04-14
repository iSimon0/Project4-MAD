package com.example.mad_p4;

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

    private String baseURL;
    private String formattedURL;
    private RequestQueue requestQueue;
    private JSONObject response;

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

    public void prepareRequest() {

        // create object request
        JsonObjectRequest jsonObjectRequest = // defines the kind of request we want to do and how to handle it
                new JsonObjectRequest(
                        Request.Method.GET, // the request method
                        formattedURL, // the URL
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) { // I guess I'm supposed to capture the request here somehow

                                APIReader.this.response = response;
//                                try {
//                                    APIReader.this.response = response;
//                                }
//                                catch (JSONException e) {
//                                    e.printStackTrace();
//                                }

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
