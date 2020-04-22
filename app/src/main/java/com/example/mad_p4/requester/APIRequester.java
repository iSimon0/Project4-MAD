package com.example.mad_p4.requester;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class APIRequester {

    private RequestQueue requestQueue;
    private Request request;

    public APIRequester(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void sendRequest(Request request) {
        // add request to the queue
        requestQueue.add(request); // actually processes the request for json data

        this.request = request;

    }

    public Request getRequest() { return request; }
}
