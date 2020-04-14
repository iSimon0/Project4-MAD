package com.example.mad_p4;

import android.content.Context;

import org.json.JSONException;

public class DadJokeReader extends APIReader {

    public DadJokeReader(Context context) {
        super(context, context.getString(R.string.api));
    }

    public void requestRandomDadJoke() throws JSONException {
        prepareRequest();
    }

    public String getJoke() throws JSONException {
        return getAttribute("joke").toString();
    }
}
