package com.example.mad_p4.requester;

import android.content.Context;
import com.example.mad_p4.requester.request.SearchDadJokeRequest;

public class SearchDadJokeRequester extends APIRequester {

    private int pageNumber;
    private String searchTerm;
    private static final int MINIMUM_PAGE_NUMBER = 1;

    public SearchDadJokeRequester(Context context) {
        super(context);
    }

    public void search(String searchTerm, int pageNumber) {
        if (pageNumber < 1) pageNumber = 1; // dunno how the service will handle negatives

        this.searchTerm = searchTerm;
        this.pageNumber = pageNumber;

        enqueue(
                new SearchDadJokeRequest(searchTerm, pageNumber, getListener())
        );
    }

    public void search(String searchTerm) {
        search(searchTerm, 1);
    }

    public void search() {
        enqueue(
                new SearchDadJokeRequest(getListener())
        );
    }

    public void nextPage() {
        search(searchTerm, pageNumber + 1);
    }

    public void previousPage() {
        search(searchTerm, pageNumber - 1);
    }

    public void jumpTo(int pageNumber) {
        search(searchTerm, pageNumber);
    }

}
