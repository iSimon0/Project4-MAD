package com.example.mad_p4.request;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.example.mad_p4.listener.DadJokeErrorListener;
import com.example.mad_p4.listener.DadJokeRandomListener;

import org.json.JSONObject;

public class DadJokeRandomRequest extends DadJokeRequest {
    public DadJokeRandomRequest() {
        super(
                new DadJokeRandomListener(),
                new DadJokeErrorListener(),
                ""
        );
    }
}
