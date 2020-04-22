package com.example.mad_p4.requester;

import android.content.Context;

import com.example.mad_p4.requester.request.RandomDadJokeRequest;

public class RandomDadJokeRequester extends APIRequester {

    public RandomDadJokeRequester(Context context) {
        super(context);
//        listener = new RandomDadJokeResponseListener();
    }

    public void request() {
        enqueue(
                new RandomDadJokeRequest(
                        getListener()
                )
        );
    }
}
