/**
 * AUTHOR: IAN SIMON, MITCHELL MYERS
 * DATE: 4/23/2020
 */

package com.example.mad_p4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mad_p4.R;
import com.example.mad_p4.requester.RandomDadJokeRequester;
import com.example.mad_p4.requester.request.listener.RandomDadJokeResponseListener;

public class RandomDadJokeFragment extends Fragment {
    private String jokeSaved;
    private TextView jokeText;

    private RandomDadJokeRequester requester;
    private RandomDadJokeResponseListener listener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    private void initViews(View view) {
        jokeText = view.findViewById(R.id.randomJokeText);
    }

    private void initRequests() {
        listener = new RandomDadJokeResponseListener();
        requester = new RandomDadJokeRequester(getContext());

        listener.setTarget(jokeText); // update this text on response
        requester.setListener(listener); // attach listener to request
        requester.request(); // request a random joke
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_random,
                container, false);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("temp", jokeSaved);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        final Button button = view.findViewById(R.id.button);

        initViews(view);
        initRequests();

        if(savedInstanceState != null){
            jokeSaved = savedInstanceState.getString("temp");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requester.request();
            }
        });
    }
}
