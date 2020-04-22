package com.example.mad_p4.requester;

import android.content.Context;

import com.example.mad_p4.requester.request.DadJokeRequest;

public abstract class DadJokeRequester extends APIRequester {
    public DadJokeRequester(Context context) {
        super(context);
    }

    public DadJokeRequest getRequest() {
        return (DadJokeRequest) super.getRequest();
    }
}
