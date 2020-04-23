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
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mad_p4.R;
import com.example.mad_p4.requester.request.listener.SearchDadJokeResponseListener;
import com.example.mad_p4.requester.SearchDadJokeRequester;

public class SearchDadJokeFragment extends Fragment {
    private String jokeSearchTerm;

    private SearchDadJokeResponseListener listener;
    private SearchDadJokeRequester requester;

    private EditText searchField;
    private Button searchButton;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initRequests();
    }

    private void initViews(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        searchField = view.findViewById(R.id.searchTermInput);
        searchButton = view.findViewById(R.id.searchButton);
    }

    private void initRequests() {
        listener = new SearchDadJokeResponseListener(getActivity());
        requester = new SearchDadJokeRequester(
                getActivity()
        );

        requester.setListener(listener);
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
        initViews(view);

        if(savedInstanceState != null){
            jokeSearchTerm = savedInstanceState.getString("term");
            searchField.setText(jokeSearchTerm);
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = searchField.getText().toString();
                requester.search(searchTerm);
            }
        });
    }
}
