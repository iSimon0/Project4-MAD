package com.example.mad_p4.requester.request.listener;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class RandomDadJokeResponseListener extends DadJokeResponseListener <TextView> {

    @Override
    public void onResponse(JSONObject response) {
        String joke;

        try {
            joke = getJoke(response);

            Log.i("Random Joke", joke);
            getTarget().setText(joke);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String getJoke(JSONObject response) throws JSONException {
        return response.get("joke").toString();
    }
}
