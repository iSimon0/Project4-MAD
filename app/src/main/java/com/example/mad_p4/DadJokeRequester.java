package com.example.mad_p4;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class DadJokeRequester extends APIReader {

    public DadJokeRequester(Context context) {
        super(context, context.getString(R.string.api));
    }

    public void requestRandomDadJoke() throws JSONException {
        prepareRequest();
    }

    public String getJoke() throws JSONException {
        return getAttribute("joke").toString();
    }

    public String getJoke(JSONObject object) throws JSONException {
        return object.get("joke").toString();
    }
}
