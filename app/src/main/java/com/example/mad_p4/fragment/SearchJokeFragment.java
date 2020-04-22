package com.example.mad_p4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.mad_p4.R;
import com.example.mad_p4.requester.request.listener.SearchDadJokeResponseListener;
import com.example.mad_p4.requester.APIRequester;
import com.example.mad_p4.requester.SearchDadJokeRequester;

public class SearchJokeFragment extends Fragment {
    private String jokeSearchTerm;
    SearchDadJokeResponseListener listener;
    SearchDadJokeRequester joker;

    APIRequester reader;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        joker = new SearchDadJokeRequester(getActivity());
        listener = new SearchDadJokeResponseListener();
        // joker.setJokeListener(listener);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.temp_activity,
                container, false);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("term", jokeSearchTerm);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        final EditText input = view.findViewById(R.id.editText);
        final Button button = view.findViewById(R.id.button);

        if(savedInstanceState != null){
            jokeSearchTerm = savedInstanceState.getString("term");
            input.setText(jokeSearchTerm);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = input.getText().toString();
                joker.sendRequest(searchTerm, 1);
            }
        });
    }
}
