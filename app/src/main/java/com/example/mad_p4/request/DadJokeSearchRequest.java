package com.example.mad_p4.request;

import com.android.volley.Response;
import com.example.mad_p4.listener.DadJokeErrorListener;
import com.example.mad_p4.listener.DadJokeSearchListener;

import org.json.JSONObject;

public class DadJokeSearchRequest extends DadJokeRequest {
    public static final String SEARCH = "search";
    public static final String TERM = "?term=";
    public static final String PAGE = "?page=";
    public static final String DEFAULT_SEARCH_TERM = "";
    public static final int DEFAULT_PAGE_NUMBER = 1;

    public DadJokeSearchRequest(String term, int pageNumber) {
        super(
                new DadJokeSearchListener(),
                new DadJokeErrorListener(),
                SEARCH // gets all jokes
        );
    }

    public DadJokeSearchRequest(String term) {
        this(term, DEFAULT_PAGE_NUMBER);
    }

    public DadJokeSearchRequest() {
        this(DEFAULT_SEARCH_TERM);
    }
}
