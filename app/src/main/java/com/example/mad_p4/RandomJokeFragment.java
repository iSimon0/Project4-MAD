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
    private float inputDist;
    private String label;
    private boolean converge;
    private float finalDist;

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
        outState.putFloat("temp", inputDist);
        outState.putBoolean("converge", converge);
        outState.putString("label", label);
        outState.putFloat("final", finalDist);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        final Button button = view.findViewById(R.id.button);
        final EditText input = view.findViewById(R.id.editText2);
        final Switch conversion = view.findViewById(R.id.switch2);
        final TextView output = view.findViewById(R.id.textView3);
        final TextView outputUnit = view.findViewById(R.id.textView4);
        if(savedInstanceState != null){
            inputDist = savedInstanceState.getFloat("temp");
            converge = savedInstanceState.getBoolean("converge");
            label = savedInstanceState.getString("label");
            finalDist = savedInstanceState.getFloat("final");
            conversion.setChecked(converge);
            input.setText(Float.toString(inputDist));
            output.setText(Float.toString(finalDist));
            outputUnit.setText(label);


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
