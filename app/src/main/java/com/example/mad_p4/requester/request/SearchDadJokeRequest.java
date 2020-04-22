package com.example.mad_p4.requester.request;

import com.example.mad_p4.requester.request.listener.DadJokeErrorListener;
import com.example.mad_p4.requester.request.listener.SearchDadJokeResponseListener;

public class SearchDadJokeRequest extends DadJokeRequest {
    public static final String SEARCH = "search";
    public static final String TERM = "?term=";
    public static final String PAGE = "?page=";
    public static final String DEFAULT_SEARCH_TERM = "";
    public static final int DEFAULT_PAGE_NUMBER = 1;

    public SearchDadJokeRequest(String term, int pageNumber) {
        super(
                new SearchDadJokeResponseListener(),
                new DadJokeErrorListener(),
                SEARCH + TERM + term + PAGE + pageNumber // gets all jokes
        );
    }

    public SearchDadJokeRequest(String term) {
        this(term, DEFAULT_PAGE_NUMBER);
    }

    public SearchDadJokeRequest() {
        this(DEFAULT_SEARCH_TERM);
    }
}
