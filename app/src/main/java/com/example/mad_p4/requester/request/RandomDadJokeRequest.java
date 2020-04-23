/**
 * AUTHOR: MITCHELL MYERS
 * DATE: 4/23/2020
 */

package com.example.mad_p4.requester.request;

import com.android.volley.Response;
import com.example.mad_p4.requester.request.listener.DadJokeErrorListener;
import com.example.mad_p4.requester.request.listener.DadJokeResponseListener;
import com.example.mad_p4.requester.request.listener.RandomDadJokeResponseListener;

public class RandomDadJokeRequest extends DadJokeRequest {
    public RandomDadJokeRequest(Response.Listener listener) {
        super(
                listener,
                new DadJokeErrorListener(),
                ""
        );
    }


}
