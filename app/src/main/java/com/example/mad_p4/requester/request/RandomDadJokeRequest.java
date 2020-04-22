package com.example.mad_p4.requester.request;

import com.example.mad_p4.requester.request.listener.DadJokeErrorListener;
import com.example.mad_p4.requester.request.listener.RandomDadJokeResponseListener;

public class RandomDadJokeRequest extends DadJokeRequest {
    public RandomDadJokeRequest() {
        super(
                new RandomDadJokeResponseListener(),
                new DadJokeErrorListener(),
                ""
        );
    }
}
