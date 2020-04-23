package com.example.mad_p4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_p4.R;
import com.example.mad_p4.requester.request.SearchDadJokeRequest;
import com.example.mad_p4.requester.request.listener.SearchDadJokeResponseListener;
import com.example.mad_p4.requester.SearchDadJokeRequester;

public class SearchDadJokeFragment extends Fragment {
    private String jokeSearchTerm;

    SearchDadJokeRequest request;
    SearchDadJokeResponseListener listener;
    SearchDadJokeRequester requester;

    private RecyclerView list;
    private EditText searchField;
    private Button nextPageButton;
    private Button previousPageButton;
    private Button searchButton;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        getViews();
        initRequests();

    }

    private void getViews() {

    }

    private void initRequests() {
        listener = new SearchDadJokeResponseListener();
        requester = new SearchDadJokeRequester(
                getActivity()
        );


        listener.setTarget(list);
        requester.setListener(listener);
        requester.search();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search,
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

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String searchTerm = input.getText().toString();
//                requester.search(searchTerm);
//            }
//        });
    }
}
