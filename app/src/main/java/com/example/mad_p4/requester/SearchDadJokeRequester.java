package com.example.mad_p4.requester;

import android.content.Context;
import com.example.mad_p4.requester.request.SearchDadJokeRequest;

public class SearchDadJokeRequester extends DadJokeRequester {

    public SearchDadJokeRequester(Context context) {
        super(context);
    }

    public void sendRequest(String term, int pageNumber) {
        sendRequest(
                new SearchDadJokeRequest(term, pageNumber)
        );
    }

    public void sendRequest() {
        sendRequest(
                new SearchDadJokeRequest()
        );
    }

    public void sendRequest(String term) {
        sendRequest(
                new SearchDadJokeRequest(term)
        );
    }

}
