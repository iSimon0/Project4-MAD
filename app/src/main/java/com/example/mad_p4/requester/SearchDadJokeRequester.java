package com.example.mad_p4.requester;

import android.content.Context;
import com.example.mad_p4.request.DadJokeSearchRequest;

public class SearchDadJokeRequester extends DadJokeRequester {

    public SearchDadJokeRequester(Context context) {
        super(context);
    }

    public void sendRequest(String term, int pageNumber) {
        sendRequest(
                new DadJokeSearchRequest(term, pageNumber)
        );
    }

    public void sendRequest() {
        sendRequest(
                new DadJokeSearchRequest()
        );
    }

    public void sendRequest(String term) {
        sendRequest(
                new DadJokeSearchRequest(term)
        );
    }

}
