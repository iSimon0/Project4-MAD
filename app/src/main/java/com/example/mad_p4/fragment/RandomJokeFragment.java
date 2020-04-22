package com.example.mad_p4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.mad_p4.R;
import com.example.mad_p4.requester.RandomDadJokeRequester;

public class RandomJokeFragment extends Fragment {
    private String jokeSaved;
    RandomDadJokeRequester requester;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        requester = new RandomDadJokeRequester(getActivity());

        requester.sendRequest();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.distance_activity,
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

        if(savedInstanceState != null){
            jokeSaved = savedInstanceState.getString("temp");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requester.sendRequest();
            }
        });
    }
}
