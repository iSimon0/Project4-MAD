package com.example.mad_p4;

import android.app.Activity;

public class SearchJokeRequester extends JokeRequester {


    public SearchJokeRequester(Activity activity) {
        super(activity);
    }

    public void requestJokeSearch(String term) {
        getWebsite().appendArgs("search?term=" + term);
        getWebsite().sendRequest();
    }

}
