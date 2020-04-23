/**
 * AUTHOR: MITCHELL MYERS
 * DATE: 4/23/2020
 */

package com.example.mad_p4.requester.request.listener;

import com.android.volley.Response;

import org.json.JSONObject;

public abstract class DadJokeResponseListener <ViewType> implements Response.Listener<JSONObject> {
    ViewType target;

    public void setTarget(ViewType target) {
        this.target = target;
    }

    public ViewType getTarget() {
        return target;
    }

}
