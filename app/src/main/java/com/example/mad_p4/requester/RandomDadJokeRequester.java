package com.example.mad_p4.requester;

import android.content.Context;

import com.example.mad_p4.request.DadJokeRandomRequest;

public class RandomDadJokeRequester extends APIRequester {


    public RandomDadJokeRequester(Context context) {
        super(context);
    }

    public void sendRequest() {
        sendRequest(new DadJokeRandomRequest());
    }
}
