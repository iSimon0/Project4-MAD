/**
 * AUTHOR: MITCHELL MYERS
 * DATE: 4/23/2020
 */

package com.example.mad_p4.requester.request.listener;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class DadJokeErrorListener implements Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }
}
