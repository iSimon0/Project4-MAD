/**
 * AUTHOR: MITCHELL MYERS
 * DATE: 4/23/2020
 */

package com.example.mad_p4.requester.request;

import com.android.volley.Response;
import com.example.mad_p4.requester.request.listener.DadJokeErrorListener;
import com.example.mad_p4.requester.request.listener.DadJokeResponseListener;
import com.example.mad_p4.requester.request.listener.SearchDadJokeResponseListener;

public class SearchDadJokeRequest extends DadJokeRequest {
    public static final String SEARCH = "search";
    public static final String TERM = "?term=";
    public static final String PAGE = "&page=";
    public static final String DEFAULT_SEARCH_TERM = "";
    public static final int DEFAULT_PAGE_NUMBER = 1;

    public SearchDadJokeRequest(String term, int pageNumber, Response.Listener listener) {
        super(
                listener,
                new DadJokeErrorListener(),
                SEARCH + TERM + term + PAGE + pageNumber
        );
    }

    public SearchDadJokeRequest(Response.Listener listener) {
        super(
                listener,
                new DadJokeErrorListener(),
                SEARCH
        );
    }
}
