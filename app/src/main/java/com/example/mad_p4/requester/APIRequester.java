package com.example.mad_p4.requester;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mad_p4.requester.request.listener.DadJokeResponseListener;

public abstract class APIRequester {

    private RequestQueue requestQueue;
    private Request request;
    private Response.Listener listener;

    public APIRequester(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void enqueue(Request request) {
        this.request = request;

        // add request to the queue
        requestQueue.add(request); // actually processes the request for json data
    }

    public Request getRequest() { return request; }

    public void setListener(Response.Listener listener) {
        this.listener = listener;
    }

    public Response.Listener getListener() {
        return listener;
    }
}
