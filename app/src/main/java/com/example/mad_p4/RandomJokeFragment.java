package com.example.mad_p4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.json.JSONException;

import java.util.Random;

public class RandomJokeFragment extends Fragment {
    private String jokeSaved;
    RandomJokeRequester joker;
    RandomJokeListener listener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        joker = new RandomJokeRequester(getActivity());
        listener = new RandomJokeListener(getActivity());

        joker.setJokeListener(listener);

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
                try {
                    joker.requestRandomDadJoke();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
