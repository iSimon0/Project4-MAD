package com.example.mad_p4;

import android.app.Activity;

import androidx.fragment.app.Fragment;

public class SearchJokeRequester extends JokeRequester {


    public SearchJokeRequester(Activity activity) {
        super(activity);
    }

    public void requestJokeSearch(String term) {
        getWebsite().appendArgs("search?term=" + term);
        getWebsite().prepareRequest();
    }

}
